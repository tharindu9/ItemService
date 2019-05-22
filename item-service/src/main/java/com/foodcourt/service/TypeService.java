package com.foodcourt.service;

import com.foodcourt.model.Type;

public interface TypeService {
	
	void saveType(Type itemTypes);
	void updateType(Type itemTypes);
	void deleteType(Integer id);
	Optional<ItemTypes> getItemTypes(Integer id);
	List <ItemTypes> getAllTypes(Integer cid);

}
