package com.luv2code.springsecurity.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springsecurity.demo.entity.Account;
import com.luv2code.springsecurity.demo.entity.Group;
import com.luv2code.springsecurity.demo.service.GroupService;
@Repository
public class AccountDaoImpl implements AccountDao {
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private GroupService groupService;
	@Override
	@Transactional
	public void save(Account theAccount) {
		// TODO Auto-generated method stub
		Session crs = sessionFactory.getCurrentSession();
		crs.saveOrUpdate(theAccount);
	}

	@Override
	@Transactional
	public List<Account> getAccountByGroupId(Long groupId) {
		// TODO Auto-generated method stub
		Session crs = sessionFactory.getCurrentSession();
		Query theQuery = crs.createQuery("from Account where groupId=:GroupId", Account.class);
		theQuery.setParameter("GroupId", groupId);
		List<Account> toReturn = theQuery.getResultList();
		return toReturn;
	}

	@Override
	@Transactional
	public Account getAccount(String AccountName, Long groupId) {
		// TODO Auto-generated method stub
		Session crs = sessionFactory.getCurrentSession();
		Query<Account> theQuery = crs.createQuery("from Account where groupId=:GroupId and accountName=:AccountName", Account.class);
		theQuery.setParameter("GroupId", groupId);
		theQuery.setParameter("AccountName", AccountName);
		Account toReturn = theQuery.getSingleResult();
		return toReturn;
	}

	@Override
	@Transactional
	public List<Account> getAccountByUserName(String UserName) {
		// TODO Auto-generated method stub
		List<Group> theList = groupService.getGroupByUserName(UserName);
		List<Account> theAccountList = new ArrayList<Account>();
		for(int i = 0; i < theList.size(); i++)
		{
			Long groupId = theList.get(i).getId();
			Session crs1 = sessionFactory.getCurrentSession();
			Query nextQuery = crs1.createQuery("from Account where groupId=:GroupId", Account.class);
			nextQuery.setParameter("GroupId", groupId);
			List<Account> itmList = nextQuery.getResultList();
			for(int j = 0; j < itmList.size(); j++)
			{
				theAccountList.add(itmList.get(j));
			}
		}
		return theAccountList;
	}

	@Override
	@Transactional
	public Account getAccount(Long accountId) {
		// TODO Auto-generated method stub
		Session crs = sessionFactory.getCurrentSession();
		return crs.get(Account.class, accountId);
	}

	@Override
	@Transactional
	public Account getAccount(String accountName) {
		Object authentication = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = ((UserDetails)authentication).getUsername();
		// TODO Auto-generated method stub
		List<Group> theList = groupService.getGroupByUserName(userName);
		List<Account> theAccountList = new ArrayList<Account>();
		for(int i = 0; i < theList.size(); i++)
		{
			Long groupId = theList.get(i).getId();
			Session crs1 = sessionFactory.getCurrentSession();
			Query nextQuery = crs1.createQuery("from Account where groupId=:GroupId", Account.class);
			nextQuery.setParameter("GroupId", groupId);
			List<Account> itmList = nextQuery.getResultList();
			for(int j = 0; j < itmList.size(); j++)
			{
				theAccountList.add(itmList.get(j));
			}
		}
		for(int i = 0; i < theAccountList.size(); i++)
		{
			if(theAccountList.get(i).getAccountName().equals(accountName))
			{
				return theAccountList.get(i);
			}
		}
		return null;
	}
	
	

}
