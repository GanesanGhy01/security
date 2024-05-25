package com.spring.security.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.security.entity.User;

@Repository
public interface UserJpa extends JpaRepository<User, Integer> {
	User findByUsername(String username);
}
