package com.harish.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harish.demo.model.BatchEntity;

public interface BatchRepository extends JpaRepository<BatchEntity, Integer> {
	    
}
