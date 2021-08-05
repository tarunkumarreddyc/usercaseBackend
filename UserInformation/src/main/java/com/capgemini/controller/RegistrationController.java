package com.capgemini.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.dto.Forgot;
import com.capgemini.entities.Registration;
import com.capgemini.exception.UserAlreadyExistException;
import com.capgemini.services.RegistrationService;




@RestController
@RequestMapping("/registration")

public class RegistrationController {
	
	@Autowired
	public RegistrationService registrationService;

	/**
	 * Adding a user to database
	 * @throws UserAlreadyExistException 
	 */
	
	//localhost:9000/registration/addUser
	@PostMapping(value = "/addUser")
	public ResponseEntity<Registration> addRegistration(@RequestBody Registration registration) throws UserAlreadyExistException {
		
		

		return new ResponseEntity<Registration>(registrationService.addRegistration(registration), HttpStatus.CREATED);
	}
	@PutMapping(value = "/changePassword")
	public ResponseEntity<String> changePassword(@RequestBody Forgot forgot)
 {
		String message= registrationService.changePassword(forgot);
		
		ResponseEntity<String> entity= new ResponseEntity<String>(message,HttpStatus.OK);
		return entity;
	}
}
