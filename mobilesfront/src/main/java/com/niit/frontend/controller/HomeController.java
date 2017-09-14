package com.niit.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	
	@Autowired
	private JavaMailSender mailsender;
	
	@RequestMapping("/")
	public String showHome()
	{
		ModelAndView mv=new ModelAndView("mainpage");
		return "Welcome";
	}
	@RequestMapping("/login")
	public String showLogin()
	{
		ModelAndView mv=new ModelAndView("login");
		return "Adminhome";
	}
	@RequestMapping("/registration")
	public String showRegister()
	{
		ModelAndView mv=new ModelAndView("adminhome");
				return "registration";
	}
	@RequestMapping("/Welcome")
	public String showWelcome()
	{
		ModelAndView mv=new ModelAndView("mainpage");
		return "Welcome";
	}
	@RequestMapping("Mail")
	public void showMail()
	{
		String email1="ameerpashamohammad@gmail.com";
		String recipentaddress=email1;
		String subject="user registration";
		String message="user registred successfully";
		
     System.out.println("To"+recipentaddress);
	 System.out.println("subject:"+subject);
	 System.out.println("Message:"+message);
	  SimpleMailMessage email=new SimpleMailMessage();
	  email.setTo(recipentaddress);
	  email.setSubject(subject);
	  email.setText(message);
	  mailsender.send(email);

	}
}
