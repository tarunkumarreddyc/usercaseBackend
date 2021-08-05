package com.capgemini.test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.capgemini.entities.Registration;
import com.capgemini.entities.UserDetails;
import com.capgemini.exception.UserNotFoundException;
import com.capgemini.repository.IRegistrationRepository;
import com.capgemini.repository.UserRepository;
import com.capgemini.services.IUserDetailsService;
import com.capgemini.services.UserDetailsService;

@SpringBootTest
public class UserDetailsTest {
	
	
	@MockBean
	private UserRepository urepo;
	
	@MockBean
	private IRegistrationRepository rrepo;
	
	@Autowired
	private UserDetailsService usev;
	
	@Test
	public void testAddUserDetails(){
		UserDetails user=new  UserDetails();
	
		
		Registration reg=new Registration((Long)102L,"Rahul","Sadanavena","rahul@capgemini.com","rahul","rahul123",user);
		 user.UserDetails((Long)101L,reg, "Male", "Hyderabad", "Telangana",
				"9550068222");
		
   reg.setUserDetails(user);
  
   when(rrepo.findById(reg.getRegistrationId())).thenReturn(Optional.of(reg));
	when(urepo.save(user)).thenReturn(user);
	 
       UserDetails user2=usev.addUserDetails(user,reg.getRegistrationId());

 	
 	   assertEquals(user2.getCity(),"Hyderabad");
		
	}
	@Test
	public void testGetUser()   {
		UserDetails user=new  UserDetails();
		
		Registration reg=new Registration((Long)102L,"Rahul","Sadanavena","rahul@capgemini.com","rahul","rahul123",user);
		 user.UserDetails((Long)101L,reg, "Male", "Hyderabad", "Telangana",
				"9550068222");
		  when(rrepo.findById(reg.getRegistrationId())).thenReturn(Optional.of(reg));
	//	when(rrepo.save(reg)).thenReturn(reg);
      Registration user2=usev.getUser(102L);
 	
 	   assertEquals(user2.getLastName(),"Sadanavena");
		
	}
	@Test
	public void testUpdateDetails()  {
		UserDetails user=new  UserDetails();
		
		Registration reg=new Registration((Long)102L,"Rahul","Sadanavena","rahul@capgemini.com","rahul","rahul123",user);
		 user.UserDetails((Long)101L,reg, "Male", "Hyderabad", "Telangana",
				"9550068222");
		
		// UserDetails user2=new UserDetails();
		 user.UserDetails((Long)101L,reg, "Male", "Hyderabad", "Ap",
				"9550068222");
		 
		 when(urepo.save(user)).thenReturn(user);
      
		 UserDetails user2=usev.updateDetails(user);
 	   assertEquals(user2.getState(),"Ap");
		
	}



}
