package com.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.model.Users;
import com.practice.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/register")
	public Users register(@RequestBody Users user) {
		return userService.register(user);
	}

	@PostMapping("/login")
	public String login(@RequestBody Users user) {

		return userService.verify(user);
	}

}
