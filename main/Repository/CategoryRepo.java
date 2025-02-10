package com.food.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.model.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> 
{

}

