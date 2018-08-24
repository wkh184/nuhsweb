package com.nuhs.gcto.service;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.nuhs.gcto.model.UserSignup;
import com.nuhs.gcto.model.UserSignup;

public class UserService {
	final static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	static public UserSignup handleNewSignUp(UserSignup userSignup) {
		logger.debug("handleNewSignUp");
		String token = SecureTokenGenerator.nextToken();
		UserSignup userSignupToken = new UserSignup();
		userSignupToken.setAdid(userSignup.getAdid());
		userSignupToken.setToken(token);
		generateTokenEmail(userSignup.getEmail(), token);
		logger.debug("handleNewSignUp:Token = {}", token);
		return userSignupToken;
	}
	
	//TODO generate token email
	static private void generateTokenEmail(String recipient, String token) {
		logger.debug("generateTokenEmail");
		
	}
}
