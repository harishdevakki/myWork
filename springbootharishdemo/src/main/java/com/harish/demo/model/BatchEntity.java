package com.harish.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Tb_Batch")
public class BatchEntity {
	@Id
	@Column(name = "Batch_Id")
	private Integer BatchId;
	
	@Column(name = "Requestor")
	private String Requestor;
	
	@Column(name = "Request_Date_Time")
	private String RequestDateTime;
	
	@Column(name = "Request_Status")
	private String RequestStatus;
	
	@Column(name = "Reqeust_For_System")
	private String ReqeustForSystem;

	
	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="Batch_Id")
    private List<ItemsEntity> Items;
	
	
	
	
	public Integer getBatchId() {
		return BatchId;
	}

	public void setBatchId(Integer batchId) {
		BatchId = batchId;
	}

	public String getRequestor() {
		return Requestor;
	}

	public void setRequestor(String requestor) {
		Requestor = requestor;
	}

	public String getRequestDateTime() {
		return RequestDateTime;
	}

	public void setRequestDateTime(String requestDateTime) {
		RequestDateTime = requestDateTime;
	}

	public String getRequestStatus() {
		return RequestStatus;
	}

	public void setRequestStatus(String requestStatus) {
		RequestStatus = requestStatus;
	}

	public String getReqeustForSystem() {
		return ReqeustForSystem;
	}

	public void setReqeustForSystem(String reqeustForSystem) {
		ReqeustForSystem = reqeustForSystem;
	}

	public List<ItemsEntity> getItems() {
		return Items;
	}

	public void setItems(List<ItemsEntity> items) {
		Items = items;
	}

	
	
	
}
