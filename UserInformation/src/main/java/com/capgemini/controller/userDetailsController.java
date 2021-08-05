package com.capgemini.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.Registration;
import com.capgemini.entities.UserDetails;
import com.capgemini.exception.UserNotFoundException;
import com.capgemini.services.UserDetailsService;

@RestController
@RequestMapping("/user")
public class userDetailsController {
	
	@Autowired
	UserDetailsService userdetailService;
	
	@GetMapping("/{registrationId}")
	public ResponseEntity<Registration> getUser(@PathVariable("registrationId") Long id) throws UserNotFoundException {
		return new ResponseEntity<Registration>(userdetailService.getUser(id), HttpStatus.OK);
	}
	

	@PostMapping("/addDetails/{registrationId}")
	public ResponseEntity<UserDetails> addUserDetails(@RequestBody UserDetails user,@PathVariable ("registrationId") long id) {
		return new ResponseEntity<UserDetails>(userdetailService.addUserDetails(user,id), HttpStatus.CREATED);

	}
	
	@PutMapping("/updateDetails")
	public ResponseEntity<UserDetails> updateDetails(@RequestBody UserDetails user) throws UserNotFoundException {
		UserDetails user2=userdetailService.updateDetails(user);
		return new ResponseEntity<UserDetails>(user2, HttpStatus.OK);
	}


}
