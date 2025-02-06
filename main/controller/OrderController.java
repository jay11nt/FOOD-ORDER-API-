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

import com.food.exception.OrderException;
import com.food.model.OrderDetails;
import com.food.service.OrderService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class OrderController 
{
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/addOrder")
	public ResponseEntity<OrderDetails>addOrder(@RequestBody OrderDetails orderDetails) throws OrderException
	{
		OrderDetails order = orderService.addOrder(orderDetails);
		return new ResponseEntity<OrderDetails>(order,HttpStatus.CREATED);
	}
	
	@PutMapping("/updateOrder/{id}")
	public ResponseEntity<OrderDetails>updateOrder(@RequestBody OrderDetails order,@PathVariable("id") Integer id) throws OrderException
	{
		OrderDetails updateOrder = orderService.updateOrder(order, id);
		return new ResponseEntity<OrderDetails>(updateOrder,HttpStatus.OK);
	}
	
	@DeleteMapping("/removeOrder/{id}")
	public ResponseEntity<OrderDetails>removeOrder(@PathVariable("id") Integer id)throws OrderException
	{
		OrderDetails removeOrder = orderService.removeOrder(id);
		return new ResponseEntity<OrderDetails>(removeOrder,HttpStatus.OK);
	}
	
	@GetMapping("/viewOrder/{id}")
	public ResponseEntity<OrderDetails>viewOrder(@PathVariable("id") Integer id)throws OrderException
	{
		OrderDetails viewOrder = orderService.viewOrder(id);
		return new ResponseEntity<OrderDetails>(viewOrder,HttpStatus.FOUND);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<OrderDetails>getAllOrderDetails()throws OrderException
	{
		List<OrderDetails> allOrderDetails = orderService.getAllOrderDetails();
		return new ResponseEntity<OrderDetails>(HttpStatus.FOUND);
	}

}

