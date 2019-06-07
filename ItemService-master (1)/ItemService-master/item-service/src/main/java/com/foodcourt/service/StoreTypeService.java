package com.foodcourt.service;

import java.util.List;

import com.foodcourt.model.StoreType;

public interface StoreTypeService {

	List <StoreType> fetchAll();
	StoreType findOne(Integer id);
	StoreType save(StoreType StoreTypes);
	StoreType update(StoreType StoreTypes);
	void delete(StoreType StoreType);
}
