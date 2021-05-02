package com.evaluationfadel.employees.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ApplicationController {

	@RequestMapping("/")
	public String redirectToHomePage() {
		return "home";
	}
	
	

	@RequestMapping("/employeesinfo")
	public ModelAndView redirectToEmployeesInfoPage() {
		ModelAndView modelAndView = new ModelAndView("employees");
		return modelAndView;
		// return "/webapp/webpages/employees.jsp";
	}

}
