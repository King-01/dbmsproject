package com.luv2code.springsecurity.demo.controller;

import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springsecurity.demo.entity.User;
import com.luv2code.springsecurity.demo.service.UserService;
import com.luv2code.springsecurity.demo.user.CrmUser;

@Controller
@RequestMapping("/register")
public class RegistrationController {
	
    @Autowired
    private UserService userService;
	
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

	@PostMapping("/processRegistrationForm")
	public String processRegistrationForm(
				@Valid @ModelAttribute("crmUser") CrmUser theCrmUser, 
				BindingResult theBindingResult, 
				Model theModel) {
//		if(theCrmUser.getUserName() == null)
//		{
//			theModel.addAttribute("registrationError", "Form Should not be Empty!");
////			theModel.addAttribute("crmUser", new CrmUser ());
//			logger.warning("Form Should not be Empty!");
//			return "registration-form";
//			
//		}
//		logger.info(theCrmUser.getPassword());
//		logger.info(theCrmUser.getMatchingPassword());
		Object authentication = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(authentication instanceof UserDetails)
		{
			return "redirect:/";
		}
		String userName = theCrmUser.getUserName();
		logger.info("Processing registration form for: " + userName);
//		if(theCrmUser.getMatchingPassword() == null || theCrmUser.getPassword() == null)
//		{
//			theModel.addAttribute("registrationError", "Password and Confirmation Password should be 8 - 45 characters long!");
////			theModel.addAttribute("crmUser", new CrmUser ());
//			logger.warning("Password should be 8 - 45 characters long!");
//			return "registration-form";
//
//		}
//        if(!theCrmUser.getMatchingPassword().equals(theCrmUser.getPassword()))
//		{
//			theModel.addAttribute("registrationError", "Password and confirmation Password does not match!");
////    			theModel.addAttribute("crmUser", new CrmUser ());
//			logger.warning("Password and confirmation Password does not match!");
//			return "registration-form";
//		}
//        else if(theCrmUser.getPassword().length() < 8 || theCrmUser.getPassword().length() > 45)
//        {
//        	logger.info(Integer.toString(theCrmUser.getPassword().length()));
//			theModel.addAttribute("registrationError", "Password  should be between 8 - 45 characters long!");
////			theModel.addAttribute("crmUser", new CrmUser ());
//			logger.warning("Password should be between 8 - 45 characters long!");
//			return "registration-form";
//        	
//        }
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
     // create user account        						
        userService.save(theCrmUser);
        
        logger.info("Successfully created user: " + userName);
        
        return "registration-confirmation";		
	}
}
