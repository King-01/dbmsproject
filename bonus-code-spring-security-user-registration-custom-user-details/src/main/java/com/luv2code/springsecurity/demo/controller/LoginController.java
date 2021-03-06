package com.luv2code.springsecurity.demo.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springsecurity.demo.user.CrmUser;

@Controller
public class LoginController {

	@RequestMapping("/showMyLoginPage")
	public String showMyLoginPage() {
		Object authentication = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(authentication instanceof UserDetails)
		{
			return "redirect:/";
		}

		return "fancy-login";
		
	}
	
	// add request mapping for /access-denied
	
	@RequestMapping("/access-denied")
	public String showAccessDenied() {
		return "access-denied";
		
	}
	
}









