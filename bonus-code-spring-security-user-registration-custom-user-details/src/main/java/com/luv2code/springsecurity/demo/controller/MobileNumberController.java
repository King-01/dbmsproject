package com.luv2code.springsecurity.demo.controller;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springsecurity.demo.service.CompanyMobileNumberService;

@Controller
public class MobileNumberController {
	@Autowired
	private CompanyMobileNumberService companyMobileNumberService;
	private Logger logger = Logger.getLogger(getClass().getName());
	@RequestMapping("/addMobileNumber")
	public String addNumber()
	{
		return "home";
	}
}
