package com.foodcourt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.ranges.RangeException;

import com.foodcourt.exception.ItemException;
import com.foodcourt.model.Item;
import com.foodcourt.repository.ItemRepository;
import com.foodcourt.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	ItemRepository itemRepository;

	@Override
	public Item save(Item item) {
		List<Item> items = fetchAll();
		boolean flag = false;
		if(items.size()>0){
			System.out.println("size is ***** "+items.size());
			for (Item item1 : items) {
				if (item1.getName().equals(item.getName()) &&
						item1.getBrand().getId() == item.getBrand().getId() &&
						item1.getUom().getId() == item.getUom().getId()
				) {

					flag = true;//item exist
					break;
				}
			}
			if (flag) {
				throw new RuntimeException("Item is not uniq");

			} else {

			if(item.getSalesPrice().compareTo(item.getUnitPrice())<0){
				throw  new RuntimeException("sales price must be greater than unit price ");
			}

			else {
				return itemRepository.save(item);
			}
			}
		}
	    else{
			return itemRepository.save(item);
		}

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
			throw new ItemException("can not find item id :" + id);
		}
	}

	@Override
	public Item update(Item item) {
		Optional<Item> opItem = itemRepository.findById(item.getId());
		if (opItem.isPresent()) {
			return itemRepository.save(item);
		} else {
			throw new ItemException("can not find item id :" + item.getId());
		}
	}

	@Override
	public void delete(Long id) {
		Optional<Item> opItem = itemRepository.findById(id);
		if (opItem.isPresent()) {
			itemRepository.deleteById(id);
		} else {
			throw new ItemException("can not find item id :" );
		}
	}

	public List<Item> critical() {
		return null;
	}

	@Override
	public Item findByName(String name) {
		return itemRepository.findByName(name);
	}
}
