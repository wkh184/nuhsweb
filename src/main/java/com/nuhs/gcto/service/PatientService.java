package com.nuhs.gcto.service;


import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;

import com.nuhs.gcto.model.IResult;
import com.nuhs.gcto.model.LabResult;
import com.nuhs.gcto.model.Patient;
import com.nuhs.gcto.model.ReadmResultPrediction;
import com.nuhs.gcto.model.ResultPrediction;

public class PatientService {
	final static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	public static Model simulateLoadPatient(Model model) {
		Patient patient = new Patient();
		patient.setAttendingDoctor("Dr Ngiam");
		patient.setLocation("Ward 1");
		patient.setGender("Male");
		patient.setDob("1/1/1900");
		model.addAttribute("patient", patient);
		LabResult labResult = new LabResult();
		labResult.setLabResult("Positive");
		labResult.setLabTest("Blood test");
		labResult.setOrderDate("1/1/2018");
		model.addAttribute("labResult", labResult);

		ResultPrediction readmission = ResultPredictionService.getResult("readm", "test1234");
		IResult readmPresentator = ResultFactory.getResult(ResultFactory.READM, readmission);
		logger.debug("simulateLoadPatient result = {}", readmission.getResult());
		model.addAttribute("readmission", readmPresentator);

		ResultPrediction dpm = ResultPredictionService.getResult("dpm", "test1234");
		IResult dpmPresentator = ResultFactory.getResult(ResultFactory.DPM, dpm);
		logger.debug("simulateLoadPatient result = {}", dpm.getResult());
		model.addAttribute("dpm", dpmPresentator);

		ResultPrediction dvt = ResultPredictionService.getResult("dvt", "test1234");
		IResult dvtPresentator = ResultFactory.getResult(ResultFactory.DVT, dvt);
		logger.debug("simulateLoadPatient result = {}", dvt.getResult());
		model.addAttribute("dvt", dvtPresentator);

		return model;

	}

}
