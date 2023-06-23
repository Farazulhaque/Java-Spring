package com.practice.blogapp.services;

import java.util.List;

import com.practice.blogapp.payloads.CategoryDto;

public interface CategoryService {

    public CategoryDto createCategory(CategoryDto categoryDto);

    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

    public void deleteCategory(Integer categoryId);

    CategoryDto getCategory(Integer categoryId);

    List<CategoryDto> getCategories();

}
