package com.foodcourt.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.foodcourt.model.Category;
import com.foodcourt.model.ItemType;
import com.foodcourt.service.TypeService;
import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value="/typecloud")
public class TypeController {
	
	@Autowired
	TypeService typeService;
	
	
	@RequestMapping(value="category/{cid}/itemtype", method=RequestMethod.POST)
	public void save( @RequestBody ItemType itemTypes,@PathVariable Integer cid )
	{
		itemTypes.setCategory(new Category (cid, ""));
		typeService.save(itemTypes);
	}
	
	@RequestMapping(value="category/{cid}/itemtype", method=RequestMethod.GET)
	public List<ItemType> getAll (@PathVariable Integer cid)
	{
		return typeService.getAll(cid);
	}
	
	@RequestMapping(value="itemtype/{id}", method=RequestMethod.GET)	
	public Optional<ItemType> getItem(@PathVariable Integer id) 
	{
		if(typeService.getItemTypes(id).isPresent()) {
			return typeService.getItemTypes(id);
		}
		else {
			//throw new IdNotFound("Can't find this id : " + id);
			return null;
		}
		
	}
	
	@RequestMapping(value="category/{cid}/itemtype/{id}", method=RequestMethod.PUT)
	public void update( @RequestBody ItemType itemTypes,@PathVariable Integer cid, Integer id )
	{
		itemTypes.setCategory(new Category (cid, ""));
		typeService.update(itemTypes);
	}
	
	@RequestMapping(value="category/{cid}/itemtype/{id}", method=RequestMethod.DELETE)
	public void delete( @RequestBody ItemType itemYpe )
	{
		typeService.delete(itemYpe);
	}
}
