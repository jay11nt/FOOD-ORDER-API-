package com.food.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food.exception.CartException;
import com.food.exception.ItemException;
import com.food.model.FoodCart;
import com.food.model.Item;
import com.food.service.CartService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class CartController 
{
	@Autowired
	private CartService cartService;
	
	@PostMapping("/addFoodCart")
	public ResponseEntity<FoodCart>addFoodCart(@RequestBody FoodCart foodCart)throws CartException
	{
		FoodCart cart = cartService.addFoodCart(foodCart);
		return new ResponseEntity<FoodCart> (cart,HttpStatus.CREATED);
	}
	
	@PutMapping("/addItemToFoodCart/{id}")
	public ResponseEntity<FoodCart>addItemToFoodCart(@RequestBody Item item,@PathVariable ("id") Integer id)throws CartException,ItemException
	{
		FoodCart cart = cartService.addItemToFoodCart(id, item);
		return new ResponseEntity<FoodCart>(cart,HttpStatus.OK);
	}
	
	@PutMapping("/increaseQuantity/{id}/{quantity}")
	public ResponseEntity<FoodCart> increaseQuantity(@RequestBody Item item,@PathVariable ("id") Integer id,@PathVariable("quantity")Integer quantity)throws CartException,ItemException
	{
		FoodCart cart = cartService.increaseQuantity(id,item,quantity);
		return new ResponseEntity<FoodCart>(cart,HttpStatus.OK);
	}
	
	@PutMapping("/reduceQuantity/{id}/{quantity}")
	public ResponseEntity<FoodCart>reduceQuantity(@RequestBody Item item,@PathVariable ("id") Integer id,@PathVariable("quantity")Integer quantity)throws CartException,ItemException
	{
		FoodCart cart = cartService.reduceQuantity(id,item,quantity);
		return new ResponseEntity<FoodCart>(cart,HttpStatus.OK);
	}
	
	@PutMapping("/removeItemFormCart/{id}")
	public ResponseEntity<FoodCart>removeItemFormCart(@RequestBody Item item,@PathVariable ("id") Integer id)throws CartException,ItemException
	{
		FoodCart cart = cartService.removeItemFormCart(id, item);
		return new ResponseEntity<FoodCart>(cart,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteCart")
	public ResponseEntity<FoodCart>deletecart(@RequestBody FoodCart cart)throws CartException
	{
		FoodCart deleteCart = cartService.deleteCart(cart);
		return new ResponseEntity<FoodCart>(cart,HttpStatus.OK);
	}

}

