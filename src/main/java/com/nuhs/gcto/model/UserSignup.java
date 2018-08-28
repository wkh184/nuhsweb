package com.nuhs.gcto.model;

import javax.persistence.Entity;

import org.hibernate.envers.Audited;

@Entity
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
