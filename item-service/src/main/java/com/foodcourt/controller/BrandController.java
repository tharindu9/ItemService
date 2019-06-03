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

import com.foodcourt.model.Brand;
import com.foodcourt.model.Item;
import com.foodcourt.service.BrandService;


@RestController
@RequestMapping("brand")
public class BrandController {
	
	@Autowired
	BrandService brandService;
	
	@RequestMapping( method = RequestMethod.POST)
	public Brand save(@RequestBody Brand batch) {
		return brandService.save(batch);
	}

	@RequestMapping( method = RequestMethod.GET)
	public List<Brand> fetchAll() {
		return brandService.fetchAll();
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<Brand> fetch(@PathVariable Integer id)  {
		Brand Brand1 = new Brand();
		Brand1.setId(id);
		Brand Brand2 = brandService.fetchOne(Brand1);
		if (Brand2 == null) {
			return null;
		} else {
			return new ResponseEntity<Brand>(Brand2, HttpStatus.OK);
		}
	}

	@RequestMapping( method = RequestMethod.PUT)
	public Brand update(@RequestBody Brand Brand) {
		if(Brand == null){
			return null;
		}
		else{
			return brandService.update(Brand);
		}
	}

	@RequestMapping( method = RequestMethod.DELETE)
	public void delete(@RequestBody Brand Brand) {
			brandService.delete(Brand);
	}
	
	@RequestMapping(value = "{id}/item" , method = RequestMethod.GET)
	public ResponseEntity<List<Item>> fetchItems(@PathVariable Integer id){
		Brand brand = new Brand();
		brand.setId(id);
		List<Item> items  = brandService.fetchOne(brand).getItems();
		return new ResponseEntity<List<Item>>(items,HttpStatus.OK);
	}
	
}
