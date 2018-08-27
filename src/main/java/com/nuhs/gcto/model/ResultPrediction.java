package com.nuhs.gcto.model;

import java.sql.Timestamp;

import javax.persistence.Entity;

import org.hibernate.envers.Audited;

@Entity
@Audited
public class ResultPrediction implements IAuditDBRecord {
	private int id;
	private String patientMRN;
	private String result;
	private String resultDescription;
	private String predictor;
	private Timestamp dtPredicted;

	public ResultPrediction() {
		super();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPatientMRN() {
		return patientMRN;
	}
	public void setPatientMRN(String patientMRN) {
		this.patientMRN = patientMRN;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getResultDescription() {
		return resultDescription;
	}
	public void setResultDescription(String resultDescription) {
		this.resultDescription = resultDescription;
	}
	public String getPredictor() {
		return predictor;
	}
	public void setPredictor(String predictor) {
		this.predictor = predictor;
	}
	public Timestamp getDtPredicted() {
		return dtPredicted;
	}
	public void setDtPredicted(Timestamp dtPredicted) {
		this.dtPredicted = dtPredicted;
	}


}
