package com.food.service;

import java.util.List;

import com.food.exception.OrderException;
import com.food.model.OrderDetails;

public interface OrderService 
{
	public OrderDetails addOrder(OrderDetails orderDetails) throws OrderException;
	
	public OrderDetails updateOrder(OrderDetails order, Integer id) throws OrderException;
	
	public OrderDetails removeOrder(Integer orderId) throws OrderException;
	
	public OrderDetails viewOrder(Integer orderId) throws OrderException;
	
	public List<OrderDetails> getAllOrderDetails() throws OrderException;

}

