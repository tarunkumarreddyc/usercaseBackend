package com.capgemini.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.exception.LoginNotFoundException;
import com.capgemini.exception.RegistrationNotFoundException;
import com.capgemini.exception.UserAlreadyExistException;
import com.capgemini.exception.UserNotFoundException;

@RestControllerAdvice
public class GlobalException {
	@ExceptionHandler(RegistrationNotFoundException.class)
	public ResponseEntity<String> handleOrderExceptionNotFound(RegistrationNotFoundException lnf) {
		ResponseEntity<String> entity = new ResponseEntity<String>(lnf.getMessage(), HttpStatus.NOT_FOUND);
		return entity;
	}
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> handleCustomerExceptionNotFound(UserNotFoundException cnf) {
		ResponseEntity<String> entity = new ResponseEntity<String>(cnf.getMessage(), HttpStatus.NOT_FOUND);
		return entity;
	}
	@ExceptionHandler(UserAlreadyExistException.class)
	public ResponseEntity<String> handleCustomerExceptionNotFound(UserAlreadyExistException cnf) {
		ResponseEntity<String> entity = new ResponseEntity<String>(cnf.getMessage(), HttpStatus.NOT_FOUND);
		return entity;
	}
	@ExceptionHandler(LoginNotFoundException.class)
	public ResponseEntity<String> handleCustomerExceptionNotFound(LoginNotFoundException cnf) {
		ResponseEntity<String> entity = new ResponseEntity<String>(cnf.getMessage(), HttpStatus.NOT_FOUND);
		return entity;
	}
}
