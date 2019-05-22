package com.foodcourt.service;

import java.util.List;
import java.util.Optional;

import com.foodcourt.model.ItemType;

public interface TypeService {
	
	void save(ItemType itemTypes);
	void update(ItemType itemTypes);
	void delete(ItemType itemType);
	Optional<ItemType> getItemTypes(Integer id);
	List <ItemType> getAll(Integer cid);

}
