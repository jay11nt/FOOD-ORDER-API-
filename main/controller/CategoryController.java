package com.food.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food.exception.CategoryException;
import com.food.model.Category;
import com.food.service.CategoryService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class CategoryController
{
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/addCategory")
    public ResponseEntity<Category>addCategory(@RequestBody Category category)throws CategoryException
		{
			Category category2 = categoryService.addCategory(category);
			return new ResponseEntity<Category>(category2,HttpStatus.CREATED);
		}
	
	@PutMapping("/updateCategory")
	public ResponseEntity<Category>updateCategory(@RequestBody Category category)throws CategoryException
	{
		Category updateCategory = categoryService.updateCategory(category);
		return new ResponseEntity<Category>(updateCategory,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/removeCategory/{id}")
	public ResponseEntity<Category>removeCategory(@PathVariable("id")Integer id)throws CategoryException
	{
		Category removeCategory = categoryService.removeCategory(id);
		return new ResponseEntity<Category>(removeCategory,HttpStatus.OK);
	}
	
	@GetMapping("/viewCategory/{id}")
	public ResponseEntity<Category>viewCategory(@PathVariable("id")Integer id)throws CategoryException
	{
		Category viewCategory = categoryService.viewCategory(id);
		return new ResponseEntity<Category>(viewCategory,HttpStatus.FOUND);
	}
	
	@GetMapping("/getAllCategory")
	public ResponseEntity<List<Category>>viewAllCategory()throws CategoryException
	{
		List<Category> viewAllCategory = categoryService.viewAllCategory();
		return new ResponseEntity<List<Category>>(HttpStatus.FOUND);		
	}
	

}

