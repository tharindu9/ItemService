package com.foodcourt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodcourt.model.Type;

public interface TypeRepository extends JpaRepository<Type, Integer> {

}
