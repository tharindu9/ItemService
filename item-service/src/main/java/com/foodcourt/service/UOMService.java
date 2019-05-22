package com.foodcourt.service;

import java.util.List;
import java.util.Optional;

import com.foodcourt.model.UOM;

public interface UOMService {

	UOM save(UOM uom);
	List<UOM> fetchAll();
	UOM update(UOM uom);
	void delete(UOM uom);
	UOM fetchOne(Integer id);
	
}
