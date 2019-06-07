package com.foodcourt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodcourt.model.Brand;
import com.foodcourt.repository.BrandRepository;

@Service
public class BrandServiceImpl implements BrandService {
	
	@Autowired
	BrandRepository brandRepository;

	@Override
	public Brand save(Brand Brand) {
		return brandRepository.save(Brand);
	}

	@Override
	public List<Brand> fetchAll() {
		return brandRepository.findAll();
	}

	@Override
	public Brand fetchOne(Brand Brand) {
		Optional<Brand> opBrand = brandRepository.findById(Brand.getId());
		if (opBrand.isPresent()) {
			return opBrand.get();
		} else {
			// Here is the exception
			return null;
		}
	}

	@Override
	public Brand update(Brand Brand) {
		Optional<Brand> opBrand = brandRepository.findById(Brand.getId());
		if (opBrand.isPresent()) {
			return brandRepository.save(Brand);
		} else {
			// exception
			return null;
		}

	}

	@Override
	public void delete(Brand Brand) {
		Optional<Brand> opBrand = brandRepository.findById(Brand.getId());
		if (opBrand.isPresent()) {
			brandRepository.delete(Brand);
		}

	}

}
