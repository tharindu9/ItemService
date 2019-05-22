package com.foodcourt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodcourt.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
