package com.food.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.food.exception.RestaurantException;
import com.food.model.Restaurant;
import com.food.service.RestaurantService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class RestaurantController 
{
	@Autowired
	private RestaurantService restaurantService;
	
	@PostMapping("/addrestaurant")
	public ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant restaurant) throws RestaurantException
	{
		Restaurant restaurant2 = restaurantService.addRestaurant(restaurant);
		
		return new ResponseEntity<>(restaurant2, HttpStatus.CREATED);
		
	}
	
	@PutMapping("/updaterestaurant")
	public ResponseEntity<Restaurant> updateRestaurantById(@PathVariable Integer restaurantId) throws RestaurantException
	{
		Restaurant restaurant2 = restaurantService.updateRestaurantById(restaurantId);
		
		return new ResponseEntity<>(restaurant2, HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/deleterestaurant/{id}")
	public ResponseEntity<Restaurant> removeRestaurantById(@PathVariable Integer restaurantId) throws RestaurantException
	{
		Restaurant restaurant2 = restaurantService.removeRestaurantById(restaurantId);
		
		return new ResponseEntity<>(restaurant2, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/getrestaurant/{id}")
	public ResponseEntity<Restaurant>viewRestaurantById(@PathVariable Integer restaurantId) throws RestaurantException
	{
		Restaurant restaurant2 = restaurantService.viewRestaurantById(restaurantId);
		
		return new ResponseEntity<>(restaurant2, HttpStatus.CREATED);
	}
	
	@GetMapping("/getrestaurant/{city}")
	public ResponseEntity<List<Restaurant>>viewRestaurntByCity(@PathVariable String location)throws RestaurantException
	{
		List<Restaurant> list = restaurantService.viewRestaurntByCity(location);
		
		return new ResponseEntity<>(list,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getrestaurant/{name}")
	public ResponseEntity<List<Restaurant>>viewRestaurantByItemName(@PathVariable String location)throws RestaurantException
	{
		List<Restaurant> list = restaurantService.viewRestaurantByItemName(location);
		
		return new ResponseEntity<>(list,HttpStatus.ACCEPTED);
	}
	

}

