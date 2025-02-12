package com.food.service;

import java.util.List;

import com.food.exception.RestaurantException;
import com.food.model.Restaurant;

public interface RestaurantService 
{
	public Restaurant addRestaurant (Restaurant restaurant)throws RestaurantException;
	
	public Restaurant viewRestaurantById (Integer restaurantId)throws RestaurantException;
	
	public Restaurant updateRestaurantById (Integer restaurantId)throws RestaurantException;
	
	public Restaurant removeRestaurantById (Integer restaurantId)throws RestaurantException;
	
	public List<Restaurant> viewRestaurntByCity(String location)throws RestaurantException;
	
	public List<Restaurant> viewRestaurantByItemName(String location)throws RestaurantException;

}

