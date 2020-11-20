package com.luv2code.springsecurity.demo.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.luv2code.springsecurity.demo.entity.User;
import com.luv2code.springsecurity.demo.service.UserService;
import com.luv2code.springsecurity.demo.user.CrmUser;
import com.luv2code.springsecurity.demo.user.PasswordUser;

@Controller
public class UserUpdateController {
	@Autowired 
	private UserService userService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private SessionFactory sessionFactory;
	private Logger logger = Logger.getLogger(getClass().getName());
	    
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}	
	@RequestMapping("/updatecompanydetails")
	public String updateUser(Model theModel)
	{
		Object authentication = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(authentication instanceof UserDetails)
		{
			Authentication authentications = SecurityContextHolder.getContext().getAuthentication();
			org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User)authentications.getPrincipal();
			String userName = user.getUsername();
			com.luv2code.springsecurity.demo.entity.User currentUser = userService.findByUserName(userName);
			logger.info("Processing updating form for user : " + currentUser.getUserName());
			CrmUser toInsertUser = new CrmUser();
			toInsertUser = toInsertUser.getCrmUser(currentUser);
			theModel.addAttribute("crmUser", toInsertUser);
			return "show-update-form";
		}
		else
		{
			logger.info("Unauthorized access to Company Update form, redirecting to Login Page");
			return "redirect:/";
		}
	}
	@RequestMapping("/updateCompanyFormUpd")
	public String updateUserUpd(Model theModel)
	{
		Object authentication = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(authentication instanceof UserDetails)
		{
			Authentication authentications = SecurityContextHolder.getContext().getAuthentication();
			org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User)authentications.getPrincipal();
			String userName = user.getUsername();
			com.luv2code.springsecurity.demo.entity.User currentUser = userService.findByUserName(userName);
			logger.info("Processing updating form for user : " + currentUser.getUserName());
			CrmUser toInsertUser = new CrmUser();
			toInsertUser = toInsertUser.getCrmUser(currentUser);
			theModel.addAttribute("crmUser", toInsertUser);
			return "update-form";
		}
		else
		{
			logger.info("Unauthorized access to Company Update form, redirecting to Login Page");
			return "redirect:/";
		}
	}
	@PostMapping("/updateCompanyForm")
	@Transactional
	public String updateCompanyForm(
			@Valid @ModelAttribute("crmUser") CrmUser theCrmUser, 
			BindingResult theBindingResult, 
			Model theModel,
			RedirectAttributes ra,
			HttpSession session)
	{
		try {
			Authentication authentications = SecurityContextHolder.getContext().getAuthentication();
			org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User)authentications.getPrincipal();
			
		String userName = theCrmUser.getUserName();
		logger.info("Processing registration form for: " + userName);	
		// form validation
		logger.info(theBindingResult.toString());
		if (theBindingResult.hasErrors()){
			return "update-form";
	    }
		if(true) {
		    Session crs = sessionFactory.getCurrentSession();
		    Query<User> theUsers = crs.createQuery("from User where userName=:UserName", User.class);
		    theUsers.setParameter("UserName", userName);
		    List<User> lel = theUsers.getResultList();
		    if(lel.size() > 0 && !passwordEncoder.matches(theCrmUser.getPassword(), lel.get(0).getPassword()))
		    {
		    	theModel.addAttribute("registrationError", "Account Password and Entered Password Does not match!");
		    	theModel.addAttribute("crmUser", theCrmUser.getCrmUser(userService.findByUserName(userName)));
		    	logger.warning("Password Entered by you doesn't match, while you were inside UserUpdateController.");
		    	return "update-form";
		    }
        }
        if(true) {
		    Session crs = sessionFactory.getCurrentSession();
		    Query<User> theUsers = crs.createQuery("from User where pan=:Pan", User.class);
		    theUsers.setParameter("Pan", theCrmUser.getPan());
		    List<User> lel = theUsers.getResultList();
		    if(lel.size() > 0 && !lel.get(0).getUserName().equals(theCrmUser.getUserName()))
		    {
		    	theModel.addAttribute("registrationError", "Pan number already taken by " + lel.get(0).getUserName());
		    	theModel.addAttribute("crmUser", theCrmUser.getCrmUser(userService.findByUserName(userName)));
		    	logger.warning("Pan number already taken by " + lel.get(0).getUserName());
		    	return "update-form";
		    }
        }
        if(true) {
		    Session crs = sessionFactory.getCurrentSession();
		    Query<User> theUsers = crs.createQuery("from User where gstin=:Gstin", User.class);
		    theUsers.setParameter("Gstin", theCrmUser.getGstin());
		    List<User> lel = theUsers.getResultList();
		    if(lel.size() > 0 && !lel.get(0).getUserName().equals(theCrmUser.getUserName()))
			{
		    	int i = 0;
		    	theModel.addAttribute("crmUser", theCrmUser.getCrmUser(userService.findByUserName(userName)));
		    	theModel.addAttribute("registrationError", "GSTIN number already taken by " + lel.get(i).getUserName());
		    	logger.warning("GSTIN number already taken by " + lel.get(i).getUserName());
		    	return "update-form";
		    }
        }
        if(true) {
		    Session crs = sessionFactory.getCurrentSession();
		    Query<User> theUsers = crs.createQuery("from User where email=:Email", User.class);
		    theUsers.setParameter("Email", theCrmUser.getEmail());
		    List<User> lel = theUsers.getResultList();
		    if(lel.size() > 0 && !lel.get(0).getUserName().equals(theCrmUser.getUserName()))
		    {
		    	theModel.addAttribute("crmUser", theCrmUser.getCrmUser(userService.findByUserName(userName)));
		    	theModel.addAttribute("registrationError", "Email already taken by " + lel.get(0).getUserName());
		    	logger.warning("Email already taken by " + lel.get(0).getUserName());
		    	return "update-form";
		    }
        }
        userService.saveExceptPassword(theCrmUser);
        ra.addFlashAttribute("successMessage", "Company details have been successfully updated!");
		User theu = userService.findByUserName(userName);
		theModel.addAttribute("successMessage", "Welcome " + theu.getDisplayName() + "!");
		session.setAttribute("UserName", theu.getUserName());
		session.setAttribute("DisplayName", theu.getDisplayName());
        logger.info("Company Details for the User " + userName + " Updated Successfully!");
		return "redirect:/updatecompanydetails";
		} catch (Exception e){
			theModel.addAttribute("registrationError", e.toString());
			return "update-form";
		}
	}
	@RequestMapping("/showFormForUpdatePassword")
	public String showFormForUpdatePassword(Model theModel)
	{
		PasswordUser toAddUser = new PasswordUser();
		Authentication authentications = SecurityContextHolder.getContext().getAuthentication();
		org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User)authentications.getPrincipal();
		String userName = user.getUsername();
		toAddUser.setUserName(userName);
		theModel.addAttribute("UpdatePasswordUser", toAddUser);
		return "update-password-form";
	}
	@PostMapping("/updatePassword")
	@Transactional
	public String updatePassword(
			@Valid @ModelAttribute("UpdatePasswordUser") PasswordUser thePasswordUser, 
			BindingResult theBindingResult,
			Model theModel
			)
	{

		try {

		String userName = thePasswordUser.getUserName();
		logger.info("Processing registration form for: " + userName);	
		// form validation
		logger.info(theBindingResult.toString());
		if (theBindingResult.hasErrors()){
			return "update-password-form";
	    }
		User theUser = userService.findByUserName(userName);
		if(!passwordEncoder.matches(thePasswordUser.getConfirmPassword(), theUser.getPassword()))
		{
			theModel.addAttribute("someerror", "Entered password does not match!");
			return "update-password-form";
		}
		theUser.setPassword(passwordEncoder.encode(thePasswordUser.getChangePassword()));
		userService.save(theUser);
		theModel.addAttribute("successMessage", "Your Password has been changed Successfully!");
		logger.info("Password for user : " + userName + "Changed Succesfully!");
		return "update-password-form";
		} catch (Exception e){
			theModel.addAttribute("registrationError", e.toString());
			return "update-password-form";
		}
	}






}
