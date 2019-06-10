package com.foodcourt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodcourt.model.UOM;
import com.foodcourt.model.UOM;
import com.foodcourt.repository.UOMRepository;

@Service
public class UOMServiceImpl implements UOMService {

	@Autowired
	UOMRepository uOMRepository;
	
	@Override
	public UOM save(UOM uom) {
		return uOMRepository.save(uom);
	}
	
	@Override
	public List<UOM> fetchAll(){
		return uOMRepository.findAll();
	}


	@Override
	public UOM update(UOM uom) {
		return uOMRepository.save(uom);
	}

	@Override
	public void delete(UOM uom) {
		uOMRepository.delete(uom);
		
	}
	
	@Override
	public UOM fetchOne(Integer id) {
		Optional<UOM> opUOM = uOMRepository.findById(id);
		if (opUOM.isPresent()) {
			return opUOM.get();
		} else {
			// Here is the exception
			return null;
		}
	}


}
