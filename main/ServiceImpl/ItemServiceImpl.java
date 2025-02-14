package com.food.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.exception.ItemException;
import com.food.model.Category;
import com.food.model.Item;
import com.food.model.Restaurant;
import com.food.repository.CategoryRepo;
import com.food.repository.ItemRepo;
import com.food.repository.RestaurantRepo;
import com.food.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService
{
	@Autowired
	private ItemRepo itemRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private RestaurantRepo restaurantRepo;
	

	@Override
	public Item addItem(Item item) throws ItemException 
	{
		if(item==null)
		{
			throw new ItemException("Item Not Be null");
		}
		return itemRepo.save(item);
	}

	@Override
	public Item viewItemById(Integer itemId) throws ItemException 
	{
		Item item = itemRepo.findById(itemId).orElseThrow(()-> new ItemException("Item Not found By id" + itemId));
		return item;
	}

	@Override
	public Item updateItemById(Item item,Integer id) throws ItemException 
	{
		Item item2 = itemRepo.findById(item.getItemId()).orElseThrow(()-> new ItemException("Item Not found for updation"));
		 return itemRepo.save(item2);
	
	}

	@Override
	public Item removeItemById(Item item,Integer id) throws ItemException 
	{
		Item item2 = itemRepo.findById(item.getItemId()).orElseThrow(()-> new ItemException("Item Not found for delete"));
		 return itemRepo.save(item2);
	}

	@Override
	public List<Item> viewAllItemsByCategory(Category cat) throws ItemException 
	{
		List<Item> list = itemRepo.findByCategory(cat);
		if(list==null)
		{
			throw new ItemException("Item not available in category");
		}
		return list;
	}

//	@Override
//	public List<Item> viewAllItems(Restaurant restaurantobj) throws ItemException 
//	{
//		if(restaurantobj !=null)
//		{
//			List<Item> list1 = new ArrayList<>();
//			itemRepo.saveAll(list1);
//			return list1;
//		}
//		else
//		{
//			throw new ItemException("list of restaurant is not available");
//			
//		}
//	}

	@Override
	public Item viewAllItemByName(String name) throws ItemException 
	{
		Item item = itemRepo.findByItemName(name);
		if(item==null)
		{
			throw new ItemException("Item not available in category");
		}
		return item;
     }

}

