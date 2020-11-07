package com.luv2code.springsecurity.demo.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class ErrorController {
	private Logger logger = Logger.getLogger(getClass().getName());
    @ExceptionHandler(value = Exception.class)
    public String handleException(HttpServletRequest request, Exception ex, Model theModel, RedirectAttributes ra) {
    	logger.warning("Request " + request.getRequestURL() + " Threw an exception : " + ex);
    	ra.addFlashAttribute("someerror", "Request " + request.getRequestURL() + " Threw an exception : " + ex);
        return "redirect:/";
    }

}