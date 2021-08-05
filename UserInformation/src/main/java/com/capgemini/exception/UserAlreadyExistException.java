package com.capgemini.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserAlreadyExistException extends Exception {

	private static final Logger logger = LoggerFactory.getLogger(UserAlreadyExistException.class);
	private static final long serialVersionUID = 1L;

	public UserAlreadyExistException(String message) {
		super(message);
		logger.info(message);
	}
}
