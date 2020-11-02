package com.luv2code.springsecurity.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springsecurity.demo.entity.CompanyMobileNumber;
import com.luv2code.springsecurity.demo.service.CompanyMobileNumberService;

@Controller
public class MobileNumberController {
	@Autowired
	private CompanyMobileNumberService companyMobileNumberService;
	private Logger logger = Logger.getLogger(getClass().getName());
	@RequestMapping("/showMobileNumber")
	public String showMobileNumber(Model theModel)
	{
		List<CompanyMobileNumber> theMobileNumbers;

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User)authentication.getPrincipal();
		String userName = user.getUsername();
		theMobileNumbers = companyMobileNumberService.getMobileNumber(userName);
		if(theMobileNumbers.size() == 2)
		{
			return "redirect:/";
		}
		else
		{
			theMobileNumbers.add(new CompanyMobileNumber());
		}
		theModel.addAttribute("CompanyMobileNumbers", theMobileNumbers);
		return "addmobilenumber";
	}
	@RequestMapping("/addMobileNumber")
	public String addMobileNumber(@Valid @ModelAttribute("CompanyMobileNumbers") List<CompanyMobileNumber> theMobileNumbers, BindingResult result, Model theModel)
	{
		if(result.hasErrors())
		{
			return "addmobilenumber";
		}
		for(int i = 0; i < theMobileNumbers.size(); i++)
		{
			
		}
		return "addmobilenumber";
	}
}
