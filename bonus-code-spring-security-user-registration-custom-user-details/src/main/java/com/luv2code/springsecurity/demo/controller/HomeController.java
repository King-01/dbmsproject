package com.luv2code.springsecurity.demo.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springsecurity.demo.service.UserService;

@Controller
public class HomeController {
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Autowired
	UserService userService;
	@RequestMapping("/")
	public String showHome(Model theModel,
			HttpSession session) {
		Object authentication = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = ((UserDetails)authentication).getUsername();
		session.setAttribute("DisplayName", userService.findByUserName(userName).getDisplayName());
		return "home";
	}
	
	@RequestMapping("/add")
	public String showAdd(Model theModel) {
		return "add";
	}
	@RequestMapping("/view")
	public String showView(Model theModel) {
		return "view";
	}

	@RequestMapping("/update")
	public String showUpdate()
	{
		return "update";
	}
}
