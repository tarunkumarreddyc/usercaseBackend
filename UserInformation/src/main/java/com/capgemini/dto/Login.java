package com.capgemini.dto;

public class Login {

	
	private String name;
	
	
	public String getName() {
		return name;
	}


	public void setName(String userName) {
		this.name = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	private String password;
}
