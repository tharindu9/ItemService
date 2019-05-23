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

import com.foodcourt.model.Batch;
import com.foodcourt.model.Batch;
import com.foodcourt.service.BatchService;

@RestController
@RequestMapping("batch")
public class BatchController {
	
	@Autowired
	BatchService batchService;
	

	@RequestMapping( method = RequestMethod.POST)
	public Batch save(@RequestBody Batch batch) {
		return batchService.save(batch);
	}

	@RequestMapping( method = RequestMethod.GET)
	public List<Batch> fetchAll() {
		return batchService.fetchAll();
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<Batch> fetchBatch(@PathVariable Integer id)  {
		Batch Batch1 = new Batch();
		Batch1.setId(id);
		Batch Batch2 = batchService.fetchOne(Batch1);
		if (Batch2 == null) {
			
			return null;
		} else {
			return new ResponseEntity<Batch>(Batch2, HttpStatus.OK);
		}
	}

	@RequestMapping( method = RequestMethod.PUT)
	public Batch update(@RequestBody Batch Batch) {
		if(Batch == null){
			return null;
		}
		else{
			return batchService.update(Batch);
	
		}
	}

	@RequestMapping( method = RequestMethod.DELETE)
	public void delete(@RequestBody Batch Batch) {
			batchService.delete(Batch);
	}

}
