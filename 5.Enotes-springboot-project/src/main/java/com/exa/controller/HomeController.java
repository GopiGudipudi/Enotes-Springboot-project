package com.exa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.exa.entity.User;
import com.exa.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
		
		@GetMapping("/register")
		public String register() {
			return "register";
	}
	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute User user,HttpSession session) {
		
		boolean f=userService.existEmailCheck(user.getEmail());
		
		if(f) {
			
			session.setAttribute("msg","Email already exists");
		}
		else {
			
		User saveUser=userService.saveUser(user);
		
		if(saveUser!=null)
		{
			session.setAttribute("msg","Register Successfully");
			
		  }
		else
		{
			  session.setAttribute("msg","server went wrong" );
		  }
		}
		return "redirect:/register";
	}
	

}
