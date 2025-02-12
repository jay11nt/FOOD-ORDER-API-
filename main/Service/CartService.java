package com.food.service;

import com.food.exception.CartException;
import com.food.exception.ItemException;
import com.food.model.FoodCart;
import com.food.model.Item;

public interface CartService 
{
	public FoodCart addFoodCart(FoodCart foodCart)throws CartException;
	
	public FoodCart addItemToFoodCart(Integer id, Item item)throws ItemException, CartException;
	
	public FoodCart increaseQuantity(Integer id, Item item, Integer quantity)throws ItemException, CartException;
	
	public FoodCart reduceQuantity(Integer id, Item item, Integer quantity)throws ItemException, CartException;
	
	public FoodCart removeItemFormCart(Integer id, Item item)throws ItemException, CartException;
	
	public FoodCart deleteCart(FoodCart cart) throws CartException;

}

