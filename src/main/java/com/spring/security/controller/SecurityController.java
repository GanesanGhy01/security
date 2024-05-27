package com.spring.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.security.entity.User;
import com.spring.security.service.JwtService;
import com.spring.security.service.RegisterService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class SecurityController {
	
	
	@Autowired
	RegisterService service;
	
	@Autowired
	JwtService jwtService;
	
	@Autowired
	AuthenticationManager mAuthenticationManager;
	
	@GetMapping("hello")
	public String greet(HttpServletRequest request) {
		return "hello world" +" "+ request.getSession().getId();
	}
	
	@GetMapping("about")
	public String about(HttpServletRequest request) {
		return "Telusko" + " "+ request.getSession().getId();
	}
	
	@PostMapping("register")
	public User save(@RequestBody User user) {
		return service.login(user);
	}
	
	@PostMapping("login")
	public String login(@RequestBody User user) {
		Authentication authentication = mAuthenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		if(authentication.isAuthenticated()) {
			return jwtService.generateToken(user.getUsername());
		}else {
			return "fail";
		}
		
	}
}
