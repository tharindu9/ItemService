package com.foodcourt.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.foodcourt.model.Category;
import com.foodcourt.service.CategoryService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/category")
//@CrossOrigin
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@RequestMapping( method = RequestMethod.POST)
	public Category save(@RequestBody Category category) {

		return categoryService.save(category);
	}

	@RequestMapping( method = RequestMethod.GET)
	public List<Category> fetchAllCategory() {
		
		return categoryService.fetchAll();
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<Category> fetchCategory(@PathVariable Integer id)  {
		Category category1 = new Category();
		category1.setId(id);
		Category category2 = categoryService.fetch(category1);
		if (category2 == null) {
			//throw new IdNotFound("Can't find this id : " + id);
			return null;
		} else {
			return new ResponseEntity<Category>(category2, HttpStatus.OK);
		}

	}

	@RequestMapping( method = RequestMethod.PUT)
	public Category update(@RequestBody Category category) {
		return categoryService.update(category);
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable  Integer id) {
		System.out.println("delete testing");
		categoryService.delete(id);
	}

}
