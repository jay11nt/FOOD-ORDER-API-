package com.food.exception;

import lombok.Data;


public class CustomerNotFound extends Exception
{

	public CustomerNotFound() 
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerNotFound(String message) 
	{
		super(message);
		// TODO Auto-generated constructor stub
	}

}

