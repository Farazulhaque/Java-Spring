package com.practice.blogapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.blogapp.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
