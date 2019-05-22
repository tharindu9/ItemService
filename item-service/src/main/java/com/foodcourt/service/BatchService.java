package com.foodcourt.service;

import java.util.List;

import com.foodcourt.model.Batch;

public interface BatchService {

	List<Batch> fetchAll();
	Batch save(Batch batch);
	Batch fetchOne(Batch batch);
	Batch update(Batch batch);
	void delete(Batch batch);
}
