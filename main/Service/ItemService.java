package com.food.service;

import java.util.List;

import com.food.exception.ItemException;
import com.food.model.Category;
import com.food.model.Item;
import com.food.model.Restaurant;

public interface ItemService 
{
	public Item addItem (Item item)throws ItemException;
	
	public Item viewItemById (Integer itemId)throws ItemException;
	
	public Item updateItemById (Item item,Integer id)throws ItemException;
	
	public Item removeItemById (Item item,Integer id)throws ItemException;
	
	public List<Item> viewAllItemsByCategory(Category cat)throws ItemException;
	
	//public List<Item> viewAllItems(Restaurant restaurantobj)throws ItemException;
	
	public Item viewAllItemByName(String name)throws ItemException;
}

