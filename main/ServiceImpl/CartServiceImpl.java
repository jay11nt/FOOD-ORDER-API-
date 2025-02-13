package com.food.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.exception.CartException;
import com.food.exception.ItemException;
import com.food.model.FoodCart;
import com.food.model.Item;
import com.food.repository.CartRepo;
import com.food.repository.ItemRepo;
import com.food.service.CartService;

@Service
public class CartServiceImpl implements CartService 
{
	@Autowired
	private CartRepo cartRepo;
	
	@Autowired
	private ItemRepo itemRepo;

	@Override
	public FoodCart addFoodCart(FoodCart foodCart) throws CartException 
	{
		if(foodCart==null)
		{
			throw new CartException("Please Enter valid Input");
		}
		
		FoodCart save = cartRepo.save(foodCart);
		
		return save;
	}

	@Override
	public FoodCart addItemToFoodCart(Integer id, Item item) throws ItemException, CartException 
	{
		FoodCart foodCart = cartRepo.findById(id).orElseThrow(()-> new CartException("Cart Not Found..."));
		
		if(item!=null)
		{
			foodCart.getItemList().add(item);
			
			FoodCart save = cartRepo.save(foodCart);
			return save;
		}
		else
		{
			throw new ItemException("Item not found.....");
		}
	}

	@Override
	public FoodCart increaseQuantity(Integer id, Item item, Integer quantity) throws ItemException, CartException 
	{
		FoodCart foodCart = cartRepo.findById(id).orElseThrow(()-> new CartException("Cart Not Found..."));
		
		List<Item> list = foodCart.getItemList();
		
		if(list.size()==0)
		{ 
			throw new ItemException("Item not found.....");
		}
		for(Item i : list)
		{
			if(i.getItemId()==item.getItemId())
			{
		      //calculates the unit cost of the item by dividing the total cost by the quantity.
			  Double cost = i.getCost() / i.getQuantity();
				                                             
		      //This updates the total cost of the item based on the new quantity
			  //(current quantity plus additional quantity).
			  i.setCost(cost * (i.getQuantity() + quantity));
				                                                
			  //This increases the quantity of the item by the specified amount.
			  i.setQuantity(i.getQuantity() + quantity); 
			}
		}
		
		FoodCart save = cartRepo.save(foodCart);
		return save;
	}

	@Override
	public FoodCart reduceQuantity(Integer id, Item item, Integer quantity) throws ItemException, CartException 
	{
        FoodCart foodCart = cartRepo.findById(id).orElseThrow(()-> new CartException("Cart Not Found..."));
		
		List<Item> list = foodCart.getItemList();
		
		if(list.size()==0)
		{ 
			throw new ItemException("Item not found.....");
		}
		for(Item i : list)
		{
			if(i.getItemId()==item.getItemId())
			{
		      //calculates the unit cost of the item by dividing the total cost by the quantity.
			  Double cost = i.getCost() / i.getQuantity();
				                                             
		      //This updates the total cost of the item based on the new quantity
			  //(current quantity plus additional quantity).
			  i.setCost(cost * (i.getQuantity() - quantity));
				                                                
			  //This increases the quantity of the item by the specified amount.
			  i.setQuantity(i.getQuantity() - quantity); 
			}
		}
		
		FoodCart save = cartRepo.save(foodCart);
		return save;
	}

	@Override
	public FoodCart removeItemFormCart(Integer id, Item item) throws ItemException, CartException 
	{
		FoodCart foodCart = cartRepo.findById(id).orElseThrow(()-> new CartException("FoodCart Not Found..."));
		
		List<Item> list = new ArrayList<>();  //Object Create........
		
		list = foodCart.getItemList();
		
		if(list.size()==0)  //check by item list
		{
			throw new ItemException("No item found....");
		}
		boolean removeIf = list.removeIf(element-> element.getItemId() == item.getItemId());
		
		if(removeIf== true)
		{
			FoodCart save = cartRepo.save(foodCart);
			return save;
		}
		else
		{
			throw new ItemException("Item not remove....");
		}
		
		
	}

	@Override
	public FoodCart deleteCart(FoodCart cart) throws CartException 
	{
		FoodCart foodCart = cartRepo.findById(cart.getCartId()).orElseThrow(()-> new CartException("Delete Cart..."));
		cartRepo.delete(foodCart);
		return foodCart;


		
	}

}

