package com.capgemini.services;

import com.capgemini.entities.Registration;
import com.capgemini.entities.UserDetails;

public interface IUserDetailsService {
	public Registration getUser(Long registrationId);
	public UserDetails addUserDetails(UserDetails user,Long registrationId);
	public UserDetails updateDetails(UserDetails user);

}
