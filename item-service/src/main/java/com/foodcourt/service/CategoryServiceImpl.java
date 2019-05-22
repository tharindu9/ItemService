package com.foodcourt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodcourt.model.Category;
import com.foodcourt.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public Category save(Category category) {

		return categoryRepository.save(category);
	}

	@Override
	public List<Category> fetchAllCategory() {

		return categoryRepository.findAll();
	}

	public Category fetchCategory(Category category) {
		Optional<Category> optional = categoryRepository.findById(category.getId());
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	@Override
	public Category updateCategory(Category category) {
		Optional<Category> optional = categoryRepository.findById(category.getId());
		if (optional.isPresent()) {
			return categoryRepository.save(category);
		} else {
			return null;
		}
	}

	@Override
	public void deleteCategory(Category category) {
		Optional<Category> optional = categoryRepository.findById(category.getId());
		if (optional.isPresent()) {
			categoryRepository.delete(category);
		}

	}

}
