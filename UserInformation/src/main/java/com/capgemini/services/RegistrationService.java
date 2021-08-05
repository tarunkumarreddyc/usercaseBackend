package com.capgemini.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.dto.Forgot;
import com.capgemini.entities.Registration;
import com.capgemini.exception.RegistrationNotFoundException;
import com.capgemini.exception.UserAlreadyExistException;
import com.capgemini.repository.IRegistrationRepository;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class RegistrationService implements IRegistrationService {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private IRegistrationRepository registrationRepository;

	@Override
	public Registration addRegistration(Registration registration) throws UserAlreadyExistException {
		logger.info("Called addRegistration() method of RegistrationService");
      if(this.registrationRepository.existsByName(registration.getName()))
    	  throw new UserAlreadyExistException("User with given name already exists");
      else
		return registrationRepository.save(registration);
	}

	@Override
	public String changePassword(Forgot forgot) {
		String email=forgot.getEmail();
		  Registration reg =registrationRepository.findByEmail(email);
		  if(reg==null) {
			  return "user not found";
		  }else {
			  reg.setPassword(forgot.getPassword());
			  registrationRepository.save(reg);
			  return "Password Changed Succesfully";
		  }
		
	}
	
	
	   
}