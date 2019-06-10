package com.foodcourt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.foodcourt.model.StoreType;
import com.foodcourt.model.StoreType;
import com.foodcourt.service.StoreTypeService;

@RestController
@RequestMapping(value="storetype")
public class StoreTypeController {

	@Autowired 
	StoreTypeService storeTypeService;
	
	@RequestMapping( method = RequestMethod.POST)
	public StoreType save(@RequestBody StoreType StoreType) {
		return storeTypeService.save(StoreType);
	}

	@RequestMapping( method = RequestMethod.GET)
	public List<StoreType> fetchAll() {
		return storeTypeService.fetchAll();
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<StoreType> fetchStoreType(@PathVariable Integer id)  {
		StoreType StoreType1 = new StoreType();
		StoreType1.setId(id);
		StoreType StoreType2 = storeTypeService.findOne(StoreType1.getId());
		if (StoreType2 == null) {
			
			return null;
		} else {
			return new ResponseEntity<StoreType>(StoreType2, HttpStatus.OK);
		}
	}

	@RequestMapping( method = RequestMethod.PUT)

	public StoreType update(@RequestBody StoreType StoreType) {
		if(StoreType == null){
			return null;
		}
		else{
			return storeTypeService.update(StoreType);
		}
	}

	@RequestMapping( method = RequestMethod.DELETE)
	public void delete(@RequestBody StoreType StoreType) {
			storeTypeService.delete(StoreType);
	}

	
	
}
