package com.nuhs.gcto.model;

import java.sql.Timestamp;

public class ResultResponse {
	private int id;
	private int result_id;
	private String adid;
	private String resultResponse;
	private String predictor;
	private Timestamp dtResponded;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getResult_id() {
		return result_id;
	}
	public void setResult_id(int result_id) {
		this.result_id = result_id;
	}
	public String getAdid() {
		return adid;
	}
	public void setAdid(String adid) {
		this.adid = adid;
	}
	public String getResultResponse() {
		return resultResponse;
	}
	public void setResultResponse(String resultResponse) {
		this.resultResponse = resultResponse;
	}
	public String getPredictor() {
		return predictor;
	}
	public void setPredictor(String predictor) {
		this.predictor = predictor;
	}
	public Timestamp getDtResponded() {
		return dtResponded;
	}
	public void setDtResponded(Timestamp dtResponded) {
		this.dtResponded = dtResponded;
	}

	
}
