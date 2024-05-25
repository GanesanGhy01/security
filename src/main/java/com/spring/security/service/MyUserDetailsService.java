package com.spring.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.security.UserPrinciple;
import com.spring.security.entity.User;
import com.spring.security.repo.UserJpa;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	private UserJpa repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repo.findByUsername(username);
		if(user == null) {
			System.out.print("404 user");
			throw new UsernameNotFoundException(" 404 not found");
		}
		return new UserPrinciple(user);
	}

}
