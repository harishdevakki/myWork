package com.harish.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Tb_Batch_Item")
public class ItemsEntity {
	@Column(name="Batch_Id")
	private Integer BatchId;
	
	@Id
	@GeneratedValue
	@Column(name="Item")
	private Integer Item;
	
	@Column(name="Name")
	private String Name;
	
	@Column(name="Email")
	private String Email;
	
	@Column(name="Init_Password")
	private String InitPassword;
	
	@Column(name="Role")
	private String Role;

	public Integer getBatchId() {
		return BatchId;
	}

	public void setBatchId(Integer batchId) {
		BatchId = batchId;
	}

	public Integer getItem() {
		return Item;
	}

	public void setItem(Integer item) {
		Item = item;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getInitPassword() {
		return InitPassword;
	}

	public void setInitPassword(String initPassword) {
		InitPassword = initPassword;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}

	
	
}
