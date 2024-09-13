package com.practice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.model.Student;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class StudentController {

	private List<Student> students = new ArrayList<>(List.of(new Student(1, "Faraz", 80), new Student(2, "Deep", 90)));

	@GetMapping("/students")
	public List<Student> getStudents() {
		return students;
	}

	@PostMapping("/students")
	public Student addStudents(@RequestBody Student student) {
		students.add(student);
		return student;
	}

	@GetMapping("/getToken")
	public CsrfToken geToken(HttpServletRequest request) {
		return (CsrfToken) request.getAttribute("_csrf");
	}
}
