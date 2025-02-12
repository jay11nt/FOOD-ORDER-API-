package com.food.service;

import com.food.exception.CustomerNotFound;
import com.food.model.Customer;

public interface CustomerService
{
	public Customer addCustomer (Customer customer)throws CustomerNotFound;
	
	public Customer updateCustomer (Customer customer)throws CustomerNotFound;
	
	public Customer removeCustomer (Integer customerId)throws CustomerNotFound;
	
	public Customer viewCustomer (Integer customerId)throws CustomerNotFound;

}

