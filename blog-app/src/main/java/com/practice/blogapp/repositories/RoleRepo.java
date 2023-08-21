package com.practice.blogapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.blogapp.entities.Role;

public interface RoleRepo extends JpaRepository<Role, Integer> {

}