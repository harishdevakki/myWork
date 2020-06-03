package com.harish.demo.serviceImpl;

import java.util.List;

import com.harish.demo.model.BatchEntity;
import com.harish.demo.model.ItemsEntity;

public interface BatchServiceImpl {

	public String postBatch(List<BatchEntity> batchEntity) ;
	public ItemsEntity getItem(String itemName);
}
