package com.foodcourt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodcourt.model.ItemType;

public interface TypeRepository extends JpaRepository<ItemType, Integer> {

	List<ItemType> findByCategoryId(Integer cid);
}
