package com.foodcourt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodcourt.exception.ItemException;
import com.foodcourt.model.Item;
import com.foodcourt.repository.ItemRepository;
import com.foodcourt.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService{


	@Autowired
	ItemRepository itemRepository;

	@Override
	public Item save(Item item) {
		return itemRepository.save(item);
	}

	@Override
	public List<Item> fetchAll() {
		return itemRepository.findAll();
	}

	@Override
	public Item fetchOne(Long id) {
		Optional<Item> opItem = itemRepository.findById(id);
		if (opItem.isPresent()) {
			return opItem.get();
		} else {
			// Here is the exception
			throw new ItemException("can not find item id :" + id);
		}
	}

	@Override
	public Item update(Item item) {
		Optional<Item> opItem = itemRepository.findById(item.getId());
		if (opItem.isPresent()) {
			return itemRepository.save(item);
		} else {
			throw new ItemException("can not find item id :" +item.getId() );
		}

	}

	@Override
	public void delete(Item item) {
		Optional<Item> opItem = itemRepository.findById(item.getId());
		if (opItem.isPresent()) {
			itemRepository.delete(item);
		}

	}
}
