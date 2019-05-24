package com.foodcourt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodcourt.exception.CategoryException;
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
	public List<Category> fetchAll() {

		return categoryRepository.findAll();
	}

	public Category fetch(Category category) {
		Optional<Category> optional = categoryRepository.findById(category.getId());
		if (optional.isPresent()) {
			return optional.get();
		} else {
		 throw new CategoryException("can not find category id" + category.getName());
		}
	}

	@Override
	public Category update(Category category) {
			return categoryRepository.save(category);
		
	}

	@Override
	public void delete(Category category) {
			categoryRepository.delete(category);
		
	}

}
