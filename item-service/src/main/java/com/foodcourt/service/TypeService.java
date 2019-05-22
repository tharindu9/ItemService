package com.foodcourt.service;

import java.util.List;
import java.util.Optional;

import com.foodcourt.model.ItemType;

public interface TypeService {
	
	void saveType(ItemType itemTypes);
	void updateType(ItemType itemTypes);
	void deleteType(Integer id);
	Optional<ItemType> getItemTypes(Integer id);
	List <ItemType> getAll(Integer cid);

}
