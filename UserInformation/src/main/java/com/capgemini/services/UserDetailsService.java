package com.capgemini.services;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entities.Registration;
import com.capgemini.entities.UserDetails;
import com.capgemini.exception.UserNotFoundException;
import com.capgemini.repository.IRegistrationRepository;
import com.capgemini.repository.UserRepository;




@Service
public class UserDetailsService implements IUserDetailsService {
	
	@Autowired
	private IRegistrationRepository registrationRepository;
	
	@Autowired
	private UserRepository userrepository;
	@Override
	public Registration getUser(Long registrationId)  {
		Optional<Registration> searchedUser = registrationRepository.findById(registrationId);
		if (searchedUser.isPresent()) {
			return searchedUser.get();
		}
		 else {
			throw new UserNotFoundException("User you are trying to view is not available");
		}
		
	}

      @Override
	public UserDetails updateDetails(UserDetails user) {
		userrepository.save(user);
		return user;
	}
   

@Override
public UserDetails addUserDetails(UserDetails user, Long registrationId) {
	
	
	Registration register= registrationRepository.findById(registrationId).orElse(null);
	if(register==null) {
		throw new UserNotFoundException("User you are trying to view is not available");
	}
	else {
		user.setRegistration(register);
		return userrepository.save(user);
	}
	
}
	
	

}
