package com.food.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food.exception.ItemException;
import com.food.model.Category;
import com.food.model.Item;
import com.food.model.Restaurant;
import com.food.service.ItemService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class ItemController 
{
	@Autowired
	private ItemService itemService;
	
	
	@PostMapping("/addItem")
	public ResponseEntity<Item>addItem(@RequestBody Item item)throws ItemException
	{
		Item item2 = itemService.addItem(item);
		return new ResponseEntity<Item>(item2,HttpStatus.CREATED);
	}
	
	@GetMapping("/getItem/{id}")
	public ResponseEntity<Item> viewItemById(@PathVariable  Integer id)throws ItemException
	{
		Item item3 = itemService.viewItemById(id);
		return new ResponseEntity<Item>(item3,HttpStatus.FOUND);
	}
	
	@PutMapping("/updateItem/{id}")
	public ResponseEntity<Item>updateItemById(@RequestBody Item item,@PathVariable ("id")Integer id)throws ItemException
	{
		Item item4 = itemService.updateItemById(item, id);
		return new ResponseEntity<Item>(item4,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/deleteItem/{id}")
	public ResponseEntity<Item>removeItemById (@RequestBody Item item,@PathVariable("id")Integer id)throws ItemException
	{
		Item remove= itemService.removeItemById(item, id);
		return new ResponseEntity<Item>(remove,HttpStatus.OK);
	}
	
	@GetMapping("/getAllItems")
	public ResponseEntity<List<Item>>viewAllItemsByCategory(@RequestBody Category cat)throws ItemException
	{
		List<Item> allItemsByCategory = itemService.viewAllItemsByCategory(cat);
		return new ResponseEntity<List<Item>>(allItemsByCategory,HttpStatus.FOUND);
	}
	
//	@GetMapping("/gellAll")
//	public ResponseEntity<List<Item>>viewAllItems(@RequestBody Restaurant restaurantobj )throws ItemException;
//	{
//	
//		
//		
//		
//	}
//	
	@GetMapping("/getAllName")
	public ResponseEntity<Item> viewAllItemByName(@PathVariable String name)throws ItemException
	{
		Item item = itemService.viewAllItemByName(name);
		return new ResponseEntity<Item>(item,HttpStatus.ACCEPTED);
	}
	
	
}

