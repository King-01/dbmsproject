package com.luv2code.springsecurity.demo.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springsecurity.demo.entity.User;
import com.luv2code.springsecurity.demo.service.UserService;
import com.luv2code.springsecurity.demo.user.CrmUser;

@Controller
@RequestMapping("/register")
public class RegistrationController {
	
    @Autowired
    private UserService userService;
	@Autowired
	private SessionFactory sessionFactory;
	
    private Logger logger = Logger.getLogger(getClass().getName());
    
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}	
	
	@GetMapping("/showRegistrationForm")
	public String showMyLoginPage(Model theModel) {
		Object authentication = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(authentication instanceof UserDetails)
		{
			return "redirect:/";
		}
		theModel.addAttribute("crmUser", new CrmUser());
		
		return "registration-form";
	}

	@RequestMapping("/processRegistrationForm")
	@Transactional
	public String processRegistrationForm(
				@Valid @ModelAttribute("crmUser") CrmUser theCrmUser, 
				BindingResult theBindingResult, 
				Model theModel) {
		Object authentication = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(authentication instanceof UserDetails)
		{
			return "redirect:/";
		}
		String userName = theCrmUser.getUserName();
		logger.info("Processing registration form for: " + userName);
        	// form validation
		 if (theBindingResult.hasErrors()){
			 return "registration-form";
	        }

		// check the database if user already exists
        User existing = userService.findByUserName(userName);
        if (existing != null){
        	theModel.addAttribute("crmUser", new CrmUser());
			theModel.addAttribute("registrationError", "User name already exists.");

			logger.warning("User name already exists.");
        	return "registration-form";
        }
        if(true) {
		    Session crs = sessionFactory.getCurrentSession();
		    Query<User> theUsers = crs.createQuery("from User where pan=:Pan", User.class);
		    theUsers.setParameter("Pan", theCrmUser.getPan());
		    List<User> lel = theUsers.getResultList();
		    if(lel.size() > 0)
		    {
		    	theModel.addAttribute("registrationError", "Pan number already taken by " + lel.get(0).getUserName());
		    	logger.warning("Pan number already taken by " + lel.get(0).getUserName());
		    	return "registration-form";
		    }
        }
        if(true) {
		    Session crs = sessionFactory.getCurrentSession();
		    Query<User> theUsers = crs.createQuery("from User where gstin=:Gstin", User.class);
		    theUsers.setParameter("Gstin", theCrmUser.getGstin());
		    List<User> lel = theUsers.getResultList();
		    if(lel.size() > 0)
		    {
		    	int i = 0;
		    	theModel.addAttribute("registrationError", "GSTIN number already taken by " + lel.get(i).getUserName());
		    	logger.warning("GSTIN number already taken by " + lel.get(i).getUserName());
		    	return "registration-form";
		    }
        }
        if(true) {
		    Session crs = sessionFactory.getCurrentSession();
		    Query<User> theUsers = crs.createQuery("from User where email=:Email", User.class);
		    theUsers.setParameter("Email", theCrmUser.getEmail());
		    List<User> lel = theUsers.getResultList();
		    if(lel.size() > 0)
		    {
		    	theModel.addAttribute("registrationError", "Email already taken by " + lel.get(0).getUserName());
		    	logger.warning("Email already taken by " + lel.get(0).getUserName());
		    	return "registration-form";
		    }
        }

     // create user account        						
        userService.save(theCrmUser);
        
        logger.info("Successfully created user: " + userName);
        
        return "registration-confirmation";		
	}
}
