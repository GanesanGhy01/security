package com.spring.security.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.security.model.Student;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class StudentController {
	
	List<Student> students = new ArrayList<>(List.of(
			new Student(1,"ganesh","java"),
			new Student(2, "hemu", "python")
			));
	@GetMapping("student")
	public List<Student> getStudent() {
		return students;
	}
	
	@PostMapping("student")
	public void saveStudent(@RequestBody Student s) {
		students.add(s);
	}
	
	@GetMapping("csrf-token")
	public CsrfToken getCsrfToken(HttpServletRequest request) {
		return (CsrfToken) request.getAttribute("_csrf");
	}
	}
