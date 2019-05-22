package com.foodcourt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodcourt.model.StoreType;
import com.foodcourt.repository.StoreTypeRepository;;

@Service
public class StoreTypeServiceImpl  implements StoreTypeService{

	@Autowired
	StoreTypeRepository storestoreTypeRepository;
	
	@Override
	public StoreType save(StoreType StoreTypes){
		return storestoreTypeRepository.save(StoreTypes);
	}
	
	@Override
	public List <StoreType> fetchAll(){
		return storestoreTypeRepository.findAll();
	}
	
	@Override
	public StoreType findOne(Integer id){
		Optional<StoreType> opStoreType  = storestoreTypeRepository.findById(id);
		if(opStoreType.isPresent()) {
			return opStoreType.get();
		}
		else {
			return null;
		}	
	}
	
	@Override
	public StoreType update(StoreType StoreTypes){
		return storestoreTypeRepository.save(StoreTypes);
	}
	
	@Override
	public void delete(StoreType StoreType){
		storestoreTypeRepository.delete(StoreType);
	}
	
}
