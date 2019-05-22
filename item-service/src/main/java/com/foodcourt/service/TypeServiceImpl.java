package com.foodcourt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodcourt.model.ItemType;
import com.foodcourt.repository.TypeRepository;

@Service
public class TypeServiceImpl implements TypeService {
	
	@Autowired
	TypeRepository typeRepository;
	
	@Override
	public List <ItemType> getAll(Integer cid)
	{
		List<ItemType> types= new ArrayList<>();
		typeRepository.findByCategoryId(cid).forEach(types :: add);
		return types;
	}
	
	@Override
	public Optional<ItemType> getItemTypes(Integer id)
	{
		return typeRepository.findById(id);
	}
	
	@Override
	public void save(ItemType itemTypes)
	{
		typeRepository.save(itemTypes);
	}
	
	@Override
	public void update(ItemType itemTypes)
	{
		typeRepository.save(itemTypes);
	}
	
	@Override
	public void delete(ItemType itemType)
	{
		typeRepository.delete(itemType);
	}
	
}
