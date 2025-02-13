package com.food.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.exception.CategoryException;
import com.food.model.Category;
import com.food.repository.CategoryRepo;
import com.food.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService 
{
	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public Category addCategory(Category cat) throws CategoryException 
	{
		if(cat!=null)
		{
			Category save = categoryRepo.save(cat);
			return save;
		}
		else
		{
			throw new CategoryException("Category Can't be null");
		}

	}

	@Override
	public Category updateCategory(Category cat) throws CategoryException 
	{
		Category category = categoryRepo.findById(cat.getCatId()).orElseThrow(()-> new CategoryException("Category not available for updation"));
		return categoryRepo.save(category);
	}

	@Override
	public Category removeCategory(Integer categoryId) throws CategoryException
	{
		Category category = categoryRepo.findById(categoryId).orElseThrow(()->new CategoryException("Category not available for deletation"));
		categoryRepo.deleteById(categoryId);
		return category;
		
	}

	@Override
	public Category viewCategory(Integer categoryId) throws CategoryException 
	{
		Category category = categoryRepo.findById(categoryId).orElseThrow(()->new CategoryException("Category not available for view"));
		return category;
	}

	@Override
	public List<Category> viewAllCategory() throws CategoryException 
	{
		List<Category> list = categoryRepo.findAll();
		if(list==null)
		{
			throw new CategoryException("Category Not Found");
		}
		return list;
		
	}
	

}

