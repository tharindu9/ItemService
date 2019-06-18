package com.foodcourt.service;

import java.util.List;

import com.foodcourt.model.Category;

public interface CategoryService {

	Category save(Category category);
	List<Category> fetchAll();
	Category fetch(Category category);
	Category update(Category category);
	void delete(Integer id);
}
