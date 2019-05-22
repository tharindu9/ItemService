package com.foodcourt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodcourt.model.Brand;

public interface BrandRepository extends JpaRepository<Brand, Integer> {

}
