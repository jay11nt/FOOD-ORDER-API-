package com.food.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.exception.OrderException;
import com.food.model.OrderDetails;
import com.food.repository.OrderRepo;
import com.food.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService
{
	@Autowired
	private OrderRepo orderRepo;

	@Override
	public OrderDetails addOrder(OrderDetails orderDetails) throws OrderException 
	{
		if(orderDetails !=null)
		{
			orderRepo.save(orderDetails);
			return orderDetails;
		}
		else
		{
			throw new OrderException("Fill all the proper detail of order");
		}
		
	}

	@Override
	public OrderDetails updateOrder(OrderDetails order, Integer id) throws OrderException 
	{
		Optional<OrderDetails> optional = orderRepo.findById(id);
		if(optional.isPresent())
		{
			OrderDetails update = orderRepo.save(order);
			return update;
		}
		else
		{
			throw new OrderException("Invalid Order detils");
		}
	}

	@Override
	public OrderDetails removeOrder(Integer orderId) throws OrderException 
	{
		Optional<OrderDetails> optional = orderRepo.findById(orderId);
		if(optional.isPresent())
		{
			OrderDetails deletedOrder = optional.get();
			orderRepo.delete(deletedOrder);
			return deletedOrder;
		}
		else
		{
			throw new OrderException("Order not found with Id"+orderId);
		}
	}

	@Override
	public OrderDetails viewOrder(Integer orderId) throws OrderException 
	{
		Optional<OrderDetails> optional = orderRepo.findById(orderId);
		if(optional.isPresent())
		{
			OrderDetails orderDetails = optional.get();
			return orderDetails;
		}
		else
		{
			throw new OrderException("Order not found with Id"+orderId);
		}


	}

	@Override
	public List<OrderDetails> getAllOrderDetails() throws OrderException 
	{
		List<OrderDetails> allOrder = orderRepo.findAll();
		if(allOrder.size()>0)
		{
			List<OrderDetails> list = new ArrayList<>(allOrder);
			return allOrder;
		}
		else
		{
			throw new OrderException("Order not found with Id");
		}
	}

}

