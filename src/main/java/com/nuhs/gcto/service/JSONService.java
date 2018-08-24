package com.nuhs.gcto.service;

import java.lang.invoke.MethodHandles;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JSONService {
	final static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	public static void parseJSON(String json) {
		JSONParser parser = new JSONParser();
		try{
			Object obj = parser.parse(json);
			JSONArray array = (JSONArray)obj;

			JSONObject obj2 = (JSONObject)array.get(1);
		}catch(ParseException pe){
			logger.error("position: {}", pe.getPosition());
			logger.error("parseJSON exception", pe);
		}	
	}
}
