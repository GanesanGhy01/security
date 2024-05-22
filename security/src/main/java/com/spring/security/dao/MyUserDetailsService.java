package com.spring.security.dao;

import com.spring.security.model.User;
import com.spring.security.UserPrinciple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService{

	
	@Autowired
	private AuthenticationDao authdao;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = authdao.findByName(username);
		if(user == null) {
			System.out.println("user not found");
			throw new UsernameNotFoundException("username not found");
		}
		return new UserPrinciple(user);
	}

}
