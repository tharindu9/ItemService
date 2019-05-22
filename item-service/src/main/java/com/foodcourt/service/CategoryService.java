package com.foodcourt.service;

import java.util.List;

import com.foodcourt.model.Category;

public interface CategoryService {

	Category save(Category category);
	List<Category> fetchAllCategory();
	Category fetchCategory(Category category);
	Category updateCategory(Category category);
	void deleteCategory(Category category);
}
