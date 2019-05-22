package com.foodcourt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodcourt.model.Item;
import com.foodcourt.repository.ItemRepository;
import com.foodcourt.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService{


	@Autowired
	ItemRepository itemRepository;

	@Override
	public Item save(Item Item) {
		return itemRepository.save(Item);
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
			return null;
		}
	}

	@Override
	public Item update(Item Item) {
		Optional<Item> opItem = itemRepository.findById(Item.getId());
		if (opItem.isPresent()) {
			return itemRepository.save(Item);
		} else {
			// exception
			return null;
		}

	}

	@Override
	public void delete(Item Item) {
		Optional<Item> opItem = itemRepository.findById(Item.getId());
		if (opItem.isPresent()) {
			itemRepository.delete(Item);
		}

	}
}
