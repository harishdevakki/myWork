package com.harish.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harish.demo.model.BatchEntity;
import com.harish.demo.model.ItemsEntity;
import com.harish.demo.service.BatchService;

@RestController
public class BatchController {

	@Autowired
	BatchService batchservice;

	@RequestMapping("/postBatch")
	public ResponseEntity<String> postBatch(@RequestBody List<BatchEntity> batchEntitys) {
		String message = "";
		try {
			batchservice.postBatch(batchEntitys);
			message = "new batch created";
		} catch (Exception e) {
			e.printStackTrace();
			message = "new batch not created";
			return new ResponseEntity<String>(message, HttpStatus.OK);
		}
		return new ResponseEntity<String>(message, HttpStatus.CREATED);
	}

	@RequestMapping("/getItem")
	public ItemsEntity getItem(@PathVariable String ItemName) {
		ItemsEntity response = new ItemsEntity();
		try {
			response = batchservice.getItem(ItemName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
}