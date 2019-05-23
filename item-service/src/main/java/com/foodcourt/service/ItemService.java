package com.foodcourt.service;

import java.util.List;

import com.foodcourt.model.Item;

public interface ItemService {

	Item save(Item Item);
	List<Item> fetchAll();
	Item fetchOne(Long id);
	Item update(Item Item);
	void delete(Item Item);
	List <Item> critical();
	
}
