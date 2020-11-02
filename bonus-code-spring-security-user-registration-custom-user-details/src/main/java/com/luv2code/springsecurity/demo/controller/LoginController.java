package com.luv2code.springsecurity.demo.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage() {
		Object authentication = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(authentication instanceof UserDetails)
		{
			return "redirect:/";
		}
		
		// return "plain-login";

		return "fancy-login";
		
	}
	
	// add request mapping for /access-denied
	
	@GetMapping("/access-denied")
	public String showAccessDenied() {
		Object authentication = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(authentication instanceof UserDetails)
		{
			return "redirect:/";
		}
		
		return "access-denied";
		
	}
	
}









