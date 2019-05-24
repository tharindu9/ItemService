package com.foodcourt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodcourt.exception.BatchException;
import com.foodcourt.model.Batch;
import com.foodcourt.model.Category;
import com.foodcourt.repository.BatchRepository;

@Service
public class BatchServiceImpl implements BatchService{

	@Autowired
	BatchRepository batchRepository;
	
	@Override
	public Batch save(Batch batch) {
		return batchRepository.save(batch);
	}
	
	@Override
	public List<Batch> fetchAll(){
		return batchRepository.findAll();
	}
	
	@Override
	public Batch fetchOne(Batch batch) {
		Optional<Batch> opBatch = batchRepository.findById(batch.getId());
		if (opBatch.isPresent()) {
			return opBatch.get();
		} else {
			//Here is the exception
		throw new BatchException("can not find batch id:"+ batch.getId());
		}
	}

	@Override
	public Batch update(Batch batch) {
		Optional<Batch> opBatch = batchRepository.findById(batch.getId());
		if(opBatch.isPresent()) {
			return batchRepository.save(batch);
		}
		else {
		
			throw new BatchException("can not find batch id:"+ batch.getId());
		}
			
	}

	@Override
	public void delete(Batch batch) {
		Optional<Batch> opBatch = batchRepository.findById(batch.getId());
		if (opBatch.isPresent()) {
			batchRepository.delete(batch);
		}
		else {
			throw new BatchException("can not find batch id:"+ batch.getId());
		}

	}
	
}
