package com.capgemini.services;

import com.capgemini.dto.Forgot;
import com.capgemini.entities.Registration;
import com.capgemini.exception.UserAlreadyExistException;

public interface IRegistrationService {
	public Registration addRegistration(Registration registration) throws UserAlreadyExistException;
    public 	String changePassword(Forgot forgot);
	
	
}
