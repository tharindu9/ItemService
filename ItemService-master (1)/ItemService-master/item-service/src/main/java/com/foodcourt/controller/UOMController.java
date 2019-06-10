package com.foodcourt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.foodcourt.model.StoreType;
import com.foodcourt.model.UOM;
import com.foodcourt.service.UOMService;

@RestController
@RequestMapping("uom")
public class UOMController {

	@Autowired 
	UOMService uOMService;
	
	@PostMapping
	public UOM save(@RequestBody UOM uom) {
		return uOMService.save(uom);
	}
	
	@GetMapping
	public List<UOM> fetchAll() {
		return uOMService.fetchAll();
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<UOM> fetchOne(@PathVariable Integer id)  {
		UOM uom1 = new UOM();
		uom1.setId(id);
		UOM uom2 = uOMService.fetchOne(id);
		if (uom2 == null) {
			//throw new IdNotFound("Can't find this id : " + id);
			return null;
		} else {
			return new ResponseEntity<UOM>(uom2, HttpStatus.OK);
		}
	}

	@RequestMapping( method = RequestMethod.PUT)
	public UOM update(@RequestBody UOM uom) {
		return uOMService.update(uom);
	}

	@RequestMapping( method = RequestMethod.DELETE)
	public void delete(@RequestBody UOM uom) {
		uOMService.delete(uom);
	}
	
}
