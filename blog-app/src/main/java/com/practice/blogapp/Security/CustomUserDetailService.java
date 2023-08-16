package com.practice.blogapp.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.practice.blogapp.entities.User;
import com.practice.blogapp.exceptions.ResourceNotFoundException;
import com.practice.blogapp.repositories.UserRepo;

public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // Load user from database
        User user = userRepo.findByEmail(username)
                .orElseThrow(() -> new ResourceNotFoundException("User", "email: " + username, 0));

        return user;
    }

}
