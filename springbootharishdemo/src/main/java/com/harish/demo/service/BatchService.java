package com.harish.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harish.demo.dao.BatchDAO;
import com.harish.demo.model.BatchEntity;
import com.harish.demo.model.ItemsEntity;
import com.harish.demo.serviceImpl.BatchServiceImpl;

@Service
public class BatchService implements BatchServiceImpl {

	@Autowired
	BatchDAO batchdao;

	public String postBatch(List<BatchEntity> batchEntity) {
		batchdao.postBatch(batchEntity);
		return null;
	}

	@Override
	public ItemsEntity getItem(String itemName) {
		// TODO Auto-generated method stub
		return batchdao.getItem(itemName);
	}

	

}
