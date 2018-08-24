package com.nuhs.gcto.service;

import com.nuhs.gcto.model.IResult;

public class ResultFactory {

	final static public String DPM = "dpm";
	final static public String READM = "readm";

	static public IResult getResult(String predictor) {
		if(predictor == null){
			return null;
		}		
		if(predictor.equalsIgnoreCase(DPM)){
			return null;

		} else if(predictor.equalsIgnoreCase(READM)){
			return null;

		}

		return null;		
	}
}
