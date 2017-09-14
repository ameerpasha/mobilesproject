package com.niit.frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String showHome()
	{
		return "Welcome";
	}
	@RequestMapping("/login")
	public String showLogin()
	{
		return "Adminhome";
	}
	@RequestMapping("/registration")
	public String showRegister()
	{
		return "registration";
	}
	@RequestMapping("/Welcome")
	public String showWelcome()
	{
		return "Welcome";
	}

}
