package com.harish.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harish.demo.model.BatchEntity;
import com.harish.demo.model.ItemsEntity;

@Service
public class BatchDAO {
	@Autowired
	BatchRepository batchRepository;

	public void postBatch(List<BatchEntity> batchEntity) {
		batchRepository.save(batchEntity);
	}

	public ItemsEntity getItem(String itemName) {
		ItemsEntity reItemsEntity = new ItemsEntity();
		List<BatchEntity> batchEntitys = batchRepository.findAll();
		for(BatchEntity entries:batchEntitys) {
			List<ItemsEntity> itemsEntities=entries.getItems();
			for(ItemsEntity entity:itemsEntities) {
				if(entity.getName().equalsIgnoreCase(itemName)) {
					entity.setBatchId(null);
					entity.setItem(null);
					reItemsEntity= entity;
				}
			}
		}
		return reItemsEntity;
	}

}
