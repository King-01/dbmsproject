package com.luv2code.springsecurity.demo.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springsecurity.demo.dao.RoleDao;
import com.luv2code.springsecurity.demo.dao.UserDao;
import com.luv2code.springsecurity.demo.entity.Role;
import com.luv2code.springsecurity.demo.entity.User;
import com.luv2code.springsecurity.demo.user.CrmUser;

@Service
public class UserServiceImpl implements UserService {

	// need to inject user dao
	@Autowired
	private UserDao userDao;

	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public User findByUserName(String userName) {
		// check the database if the user already exists
		return userDao.findByUserName(userName);
	}

	@Override
	@Transactional
	public void save(CrmUser crmUser) {
		User user = new User();
		 // assign user details to the user object
		user.setUserName(crmUser.getUserName());
		user.setPassword(passwordEncoder.encode(crmUser.getPassword()));
		user.setCity(crmUser.getCity());
		user.setAddressLine2(crmUser.getAddressLine2());
		user.setTdsAccountNumber(crmUser.getTdsAccountNumber());
		user.setAddressLine1(crmUser.getAddressLine1());
		user.setGstin(crmUser.getGstin());
		user.setPan(crmUser.getPan());
		user.setPincode(crmUser.getPincode());
		user.setEmail(crmUser.getEmail());
		user.setDisplayName(crmUser.getDisplayName());
		user.setMobileNumber1(crmUser.getMobilenumber1());
		user.setMobileNumber2(crmUser.getMobilenumber2());
		// give user default role of "employee"
		user.setRoles(Arrays.asList(roleDao.findRoleByName("ROLE_EMPLOYEE")));

		 // save user in the database
		userDao.save(user);
	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userDao.findByUserName(userName);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
				mapRolesToAuthorities(user.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

	@Override
	@Transactional
	public void saveExceptPassword(CrmUser crmUser) {
		// TODO Auto-generated method stub
		User user = userDao.findByUserName(crmUser.getUserName());
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		user.setAddressLine2(crmUser.getAddressLine2());
		user.setTdsAccountNumber(crmUser.getTdsAccountNumber());
		user.setAddressLine1(crmUser.getAddressLine1());
		user.setGstin(crmUser.getGstin());
		user.setPan(crmUser.getPan());
		user.setDisplayName(crmUser.getDisplayName());
		user.setPincode(crmUser.getPincode());
		user.setEmail(crmUser.getEmail());
		user.setMobileNumber1(crmUser.getMobilenumber1());
		user.setMobileNumber2(crmUser.getMobilenumber2());
		userDao.save(user);
	}

	@Override
	public void save(User theUser) {
		// TODO Auto-generated method stub
		userDao.save(theUser);
	}

	@Override
	@Transactional
	public User get(long id) {
		// TODO Auto-generated method stub
		return userDao.get(id);
	}
	
}
