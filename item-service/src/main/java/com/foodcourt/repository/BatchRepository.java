package com.foodcourt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodcourt.model.Batch;

public interface BatchRepository  extends JpaRepository<Batch, Integer>{

}
