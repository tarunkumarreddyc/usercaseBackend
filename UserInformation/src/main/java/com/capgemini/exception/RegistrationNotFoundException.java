package com.capgemini.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegistrationNotFoundException extends Exception {

	private static final Logger logger = LoggerFactory.getLogger(RegistrationNotFoundException.class);
	private static final long serialVersionUID = 1L;

	public RegistrationNotFoundException(String message) {
		super(message);
		logger.info(message);
	}

}
