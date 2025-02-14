package com.food.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.food.exception.CustomerNotFound;
import com.food.model.Customer;
import com.food.service.CustomerService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class CustomerController 
{
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/add")
         ResponseEntity<Customer> addCustomer(@Valid @RequestBody Customer customer)throws CustomerNotFound
	    {
		 Customer savecustomer = customerService.addCustomer(customer);
		 
		 return new ResponseEntity<Customer>(savecustomer,HttpStatus.ACCEPTED);
	    }
	
	@PutMapping("/update")
	 ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer)throws CustomerNotFound
	 {
		 Customer updatecustomer = customerService.updateCustomer(customer);
		 return new ResponseEntity<Customer>(updatecustomer,HttpStatus.ACCEPTED);
	 }
	
	
	@DeleteMapping("/delete/{id}")
	 ResponseEntity<Customer> deleteCustomer(@PathVariable("id") Integer customerId)throws CustomerNotFound
	 {
		 Customer deletecustomer = customerService.removeCustomer(customerId);
		 return new ResponseEntity<Customer>(deletecustomer,HttpStatus.OK);
	 }
	
	@GetMapping("/get/{id}")
	ResponseEntity<Customer> viewCustomer(@PathVariable("id")Integer customerId)throws CustomerNotFound
	{
		Customer getCustomer = customerService.viewCustomer(customerId);
		return new ResponseEntity<Customer>(getCustomer,HttpStatus.ACCEPTED);
	}


}

