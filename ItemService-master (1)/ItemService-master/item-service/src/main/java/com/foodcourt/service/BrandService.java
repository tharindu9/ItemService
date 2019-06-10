package com.foodcourt.service;

import java.util.List;

import com.foodcourt.model.Brand;

public interface BrandService {

	Brand save(Brand Brand);
	List<Brand> fetchAll();
	Brand fetchOne(Brand Brand);
	Brand update(Brand Brand);
	void delete(Brand Brand);
	
}
