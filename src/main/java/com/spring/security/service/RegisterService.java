package com.spring.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.security.entity.User;
import com.spring.security.repo.UserJpa;

@Service
public class RegisterService {

	@Autowired
	private UserJpa repo;
	
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
	
	public User login(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return repo.save(user);
	}

}
