package com.practice.blogapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.blogapp.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
