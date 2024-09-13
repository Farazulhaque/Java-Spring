package com.practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.practice.model.Users;
import com.practice.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	UserRepo userRepo;

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	JWTService jwtService;
	
	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);

	public Users register(Users user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		return userRepo.save(user);
	}

	public String verify(Users user) {
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

		if (authentication.isAuthenticated()) {
			return jwtService.generateToken(user.getUsername());
		}

		return "Failure";
	}
}
