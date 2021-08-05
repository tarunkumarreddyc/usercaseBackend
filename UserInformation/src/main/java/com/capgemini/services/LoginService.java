package com.capgemini.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.dto.Login;
import com.capgemini.entities.Registration;
import com.capgemini.exception.LoginNotFoundException;
import com.capgemini.repository.IRegistrationRepository;


@Service
public class LoginService implements ILoginService {

	@Autowired
	private IRegistrationRepository registrationRepository;

	
	@Override
	public String signIn(Login user) throws LoginNotFoundException {

		String name=user.getName();
		String password=user.getPassword();
		  Registration regName =registrationRepository.findByName(name);
		  Registration regPassword =registrationRepository.findByPassword(password);
		  if(regName==null) {
			  
			  return "Login Failed user name is not valid";
			  }
		  else if(regPassword==null) {
			  return "Login Failed Password is not valid";
		  }
		  else {
			  return "Login Successfull";
		  }
		  }


	
		  
}
