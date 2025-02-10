package com.food.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.model.Category;
import com.food.model.Item;

public interface ItemRepo extends JpaRepository<Item, Integer>
{
	public List<Item>findByCategory(Category category);
	
	public Item findByItemName(String name);

}

