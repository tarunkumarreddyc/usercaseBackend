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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import net.minidev.json.annotate.JsonIgnore;






@Entity
public class Registration {
	
	public Registration() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Registration(Long registrationId,
			@NotNull(message = "name cannot be null") @Size(min = 2, max = 30, message = "please enter correct name") String firstName,
			@NotNull(message = "name cannot be null") @Size(min = 2, max = 30, message = "please enter correct name") String lastName,
			@Email @NotNull(message = "email id cannot be null") String email,
			@NotNull (message = "name cannot be null") @Size(min = 2, max = 30, message = "please enter correct name") String name,
			String password, UserDetails userDetails) {
		super();
		this.registrationId = registrationId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.name = name;
		this.password = password;
		this.userDetails = userDetails;
	}


	public Registration(Long registrationId,
			@NotNull(message = "name cannot be null") @Size(min = 2, max = 30, message = "please enter correct name") String firstName,
			@NotNull(message = "name cannot be null") @Size(min = 2, max = 30, message = "please enter correct name") String lastName,
			@Email @NotNull(message = "email id cannot be null") String email,
			@NotNull(message = "name cannot be null") @Size(min = 2, max = 30, message = "please enter correct name") String name,
			String password) {
		super();
		this.registrationId = registrationId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.name = name;
		this.password = password;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long registrationId;
	
	@NotNull(message = "name cannot be null")
	@Size(min = 2, max = 30, message = "please enter correct name")
	private String firstName;
	
	@NotNull(message = "name cannot be null")
	@Size(min = 2, max = 30, message = "please enter correct name")
	private String lastName;
	
     @Email
 	@NotNull(message = "email id cannot be null")
	private String email;
  
     @NotNull(message = "name cannot be null")
 	@Size(min = 2, max = 30, message = "please enter correct name")
 	private String name;
	
//	public Registration(Long long1, String string, String string2, String string3, String string4, String string5) {
//		// TODO Auto-generated constructor stub
//	}

   

	public String getName() {
		return name;
	}


	public UserDetails getUserDetails() {
		return userDetails;
	}


	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}


	public void setName(String userName, @NotNull(message = "name cannot be null") @Size(min = 2, max = 30, message = "please enter correct name") String name) {
		this.name = name;
	}


	private String password;
	
	@OneToOne(mappedBy ="registration", cascade = CascadeType.ALL, fetch= FetchType.EAGER)
	private UserDetails userDetails;


	

	public Long getRegistrationId() {
		return registrationId;
	}


	public void setRegistrationId(Long registrationId) {
		this.registrationId = registrationId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Registration(UserDetails userDetails) {
		super();
		this.userDetails = userDetails;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
