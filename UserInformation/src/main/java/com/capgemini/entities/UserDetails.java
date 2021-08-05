package com.capgemini.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.sun.istack.NotNull;

import net.minidev.json.annotate.JsonIgnore;

@Entity
public class UserDetails {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long userId;
	
	
	
	@OneToOne(cascade = CascadeType.ALL,fetch= FetchType.EAGER)
	@JoinColumn(name = "id")
	@com.fasterxml.jackson.annotation.JsonIgnore
	private Registration registration;
	
	@NotNull
	private String gender;
	
	
	@NotNull
	private String city;
	
	@NotNull
	private String state;
	
	@NotNull
	private String phoneNumber;

//	public UserDetails(Long long1, String string, String string2, String string3, String string4) {
//		// TODO Auto-generated constructor stub
//	}

	public Registration getRegistration() {
		return registration;
	}

	public UserDetails(Long userId,  String gender, String city, String state,
		String phoneNumber) {
	super();
	this.userId = userId;
	
	this.gender = gender;
	this.city = city;
	this.state = state;
	this.phoneNumber = phoneNumber;
}

	public UserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setRegistration(Registration registration) {
		this.registration = registration;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void UserDetails(Long userId, Registration registration, String gender, String city, String state,
			String phoneNumber) {
	
		this.userId = userId;
		this.registration = registration;
		this.gender = gender;
		this.city = city;
		this.state = state;
		this.phoneNumber = phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

//	public UserDetails get() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	
	
	
	
	

}
