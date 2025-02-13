package com.food.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.exception.RestaurantException;
import com.food.model.Item;
import com.food.model.Restaurant;
import com.food.repository.ItemRepo;
import com.food.repository.RestaurantRepo;
import com.food.service.RestaurantService;

@Service
public class RestaurantServiceImpl implements RestaurantService
{
	@Autowired
	private RestaurantRepo restaurantRepo;
	
	@Autowired
	private ItemRepo itemRepo;

	@Override
	public Restaurant addRestaurant(Restaurant restaurant) throws RestaurantException 
	{
		if(restaurant==null)
		{
			throw new RestaurantException("Restaurant Not Be Null");
		}


		return restaurantRepo.save(restaurant);
	}

	@Override
	public Restaurant viewRestaurantById(Integer restaurantId) throws RestaurantException 
	{
		Restaurant throw1 = restaurantRepo.findById(restaurantId).orElseThrow(()-> new RestaurantException("Restuarant not available with id: "+ restaurantId));


		return throw1;
	}

	@Override
	public Restaurant updateRestaurantById(Integer restaurantId) throws RestaurantException 
	{
		Restaurant throw2 = restaurantRepo.findById(restaurantId).orElseThrow(()-> new RestaurantException("Restaurant not available for updation"));
		return throw2;
	}

	@Override
	public Restaurant removeRestaurantById(Integer restaurantId) throws RestaurantException 
	{
		Restaurant throw3 = restaurantRepo.findById(restaurantId).orElseThrow(()-> new RestaurantException("Restaurant not available for deletion"));
		restaurantRepo.deleteById(restaurantId);
		return throw3;
	}

	@Override
	public List<Restaurant> viewRestaurntByCity(String location) throws RestaurantException 
	{
		List<Restaurant> nearByResturantList = restaurantRepo.getNearByResturant(location);
		if(nearByResturantList==null)
		{
			throw new RestaurantException("Restuarant not available at this location: "+ location);
		}
		
		return nearByResturantList;
	}

	@Override
	public List<Restaurant> viewRestaurantByItemName(String name ) throws RestaurantException 
	{
		Item byItemName = itemRepo.findByItemName(name);
		if(byItemName==null)
		{
			throw new RestaurantException("Item name not found" + name);
		}
		if(byItemName.getRestaurant().size()==0)
		{
			throw new RestaurantException("Item not available in Restaurant right now");
		}
		
		return byItemName.getRestaurant();
	}

}

