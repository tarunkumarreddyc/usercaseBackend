package com.capgemini.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.dto.Login;
import com.capgemini.entities.Registration;
import com.capgemini.exception.LoginNotFoundException;
import com.capgemini.services.LoginService;



@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private LoginService loginService;

	@PostMapping("/signIn")
	public ResponseEntity<String> signIn(@RequestBody @Valid Login user)
			throws LoginNotFoundException {
		
String message= loginService.signIn(user);
		
		ResponseEntity<String> entity= new ResponseEntity<String>(message,HttpStatus.CREATED);
		return entity;
	}

}
