package com.capgemini.test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.capgemini.entities.Registration;
import com.capgemini.exception.UserAlreadyExistException;
import com.capgemini.repository.IRegistrationRepository;
import com.capgemini.services.RegistrationService;

@SpringBootTest
public class UserTest {
	
	@MockBean
	private IRegistrationRepository regrepo;
	
	@Autowired
	private RegistrationService regsev;
	
	@Test
	public void testaddRegistration() throws UserAlreadyExistException {
		Registration reg=new Registration((Long)101L,"Rahul","Sadanavena","rahul@capgemini.com","rahul","rahul123");
		
           when(regrepo.save(reg)).thenReturn(reg);
    	Registration user2 = regsev.addRegistration(reg);
    	   assertEquals( user2.getFirstName(),"Rahul");
		
	}
     
}