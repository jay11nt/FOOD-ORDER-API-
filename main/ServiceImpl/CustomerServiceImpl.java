package com.food.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.exception.CustomerNotFound;
import com.food.model.Customer;
import com.food.repository.CustomerRepo;
import com.food.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService
{
	@Autowired
	private CustomerRepo customerRepo;

	@Override
	public Customer addCustomer(Customer customer) throws CustomerNotFound 
	{
		if(customer!=null)
		{
			customerRepo.save(customer);
			return customer;
		}
		else
		{
			throw new CustomerNotFound("customer not found");
		}
	}

	@Override
	public Customer updateCustomer(Customer customer) throws CustomerNotFound 
	{
		 Optional<Customer> optional = customerRepo.findById(customer.getCustomerId());
			
			if(optional.isPresent()) 
			{
				Customer save = customerRepo.save(customer);
				return save;
				
			}
			else
			{
				throw new CustomerNotFound("Invalid Customer details..."); 
			}
				
			
		}
	

	@Override
	public Customer removeCustomer(Integer customerId) throws CustomerNotFound 
	{
		Optional<Customer> optional = customerRepo.findById(customerId);
		if(optional.isPresent())
		{
			customerRepo.deleteById(customerId);
			return new Customer();
		}
		else
		{
			throw new CustomerNotFound(" Customer Not Found " ); 
		}
		
	}

	@Override
	public Customer viewCustomer(Integer customerId) throws CustomerNotFound 
	{
		Optional<Customer> optional = customerRepo.findById(customerId);
		
		if(optional.isPresent())
		{
			customerRepo.getById(customerId);
			return new Customer();
		}
		else
		{
			throw new CustomerNotFound(" Customer Not Found " ); 
		}
		
	}

}

