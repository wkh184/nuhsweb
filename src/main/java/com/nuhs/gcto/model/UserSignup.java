package com.nuhs.gcto.model;

public class UserSignup extends User{
	private String token;

	public UserSignup() {
		super();
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
}
