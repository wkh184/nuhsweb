package com.nuhs.gcto.model;

import java.sql.Timestamp;

public class DBObject implements IAuditDBRecord {
	private int id;
	private Timestamp createdDT;
	private Timestamp updatedDT;
	private String createdBy = "system";
	private String updatedBy = "system";

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public Timestamp getCreatedDT() {
		return createdDT;
	}

	public void setCreatedDT(Timestamp createdDT) {
		this.createdDT = createdDT;
	}

	public Timestamp getUpdatedDT() {
		return updatedDT;
	}

	public void setUpdatedDT(Timestamp updatedDT) {
		this.updatedDT = updatedDT;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}


}
