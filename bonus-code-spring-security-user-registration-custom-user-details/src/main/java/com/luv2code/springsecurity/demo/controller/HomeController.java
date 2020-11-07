package com.luv2code.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String showHome(Model theModel) {
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
}
