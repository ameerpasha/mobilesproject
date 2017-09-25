   package com.niit.frontend.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.mobilebackend.dao.IUserDao;
import com.niit.mobilebackend.model.User;

@Controller
public class HomeController {
	
	
	
	
	
	@Autowired
	private JavaMailSender mailsender;
	
	@Autowired
	IUserDao userDao;
	
	
	@Autowired 
	User user;
	
	@ModelAttribute
	public User returnObject() {
		
		return new User();
	}
		
		
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
		return "login";
	}
	@RequestMapping("/registration")
	public String showRegister()
	{
		ModelAndView mv=new ModelAndView("adminhome");
				return "registration";
	}
	@RequestMapping("/aboutus")
	public String showaboutus()
	{
		ModelAndView mv=new ModelAndView("mainpage");
		return "aboutus";
	}
	@RequestMapping("/contactus")
	public String contactus()
	{
		ModelAndView mv=new ModelAndView("mainpage");
		return "contactus";
	}
	@RequestMapping("/Welcome")
	public String showWelcome()
	{
		ModelAndView mv=new ModelAndView("mainpage");
		return "Welcome";
	}
	/*@RequestMapping("/AddProduct")
	 public String showAddProduct()
	 {
		 ModelAndView m=new ModelAndView("AddProduct");
		 
		 return "AddProduct";
	 }*/
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
	
	@RequestMapping(value="/addus",method=RequestMethod.POST)
	public String addUser(@ModelAttribute("user") User user,BindingResult result,HttpServletRequest request) {
		System.out.println(user.getCpassword());
		System.out.println(user.getpassword());
		user.setEnabled("true");
		user.setRole("ROLE_USER");
		if(user.getCpassword().equals(user.getPassword())){
			userDao.addUser(user);
		}
		return "login";
	}
	@RequestMapping(value="/Login_session_attributes")
	/*getting values from textbox */
	public String login_session_attibutes(HttpSession session,Model model,@RequestParam(value="username") String id)
	{
		String name =SecurityContextHolder.getContext().getAuthentication().getName();
		System.out.println("inside security check");
		session.setAttribute("name",name);
		System.out.println(name);
		
		user= userDao.get(id);
		session.setAttribute("email",user.getEmailid());
		session.setAttribute("loggedInUser",user.getUsername());
		session.setAttribute("LoggedIn", "true");
		@SuppressWarnings("unchecked")
		Collection<GrantedAuthority> authorities =(Collection<GrantedAuthority>) SecurityContextHolder.getContext()
		.getAuthentication().getAuthorities();
		
		String role="ROLE_USER";
		for(GrantedAuthority authority : authorities) {
			
		
		
		if(authority.getAuthority().equals(role)) {
			System.out.println(role);
			return "viewproducts";
		}
		else
		{
			session.setAttribute("isadmin","true");
		}
		}
		
	
	return "Adminhome";
}
}
			
			

