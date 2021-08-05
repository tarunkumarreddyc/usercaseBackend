package com.capgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.entities.Registration;
@Repository
public interface IRegistrationRepository extends JpaRepository<Registration, Long>{

	
	@Query("SELECT r FROM Registration r WHERE r.email = ?1")
    public Registration findByEmail(String email); 
	
	@Query("SELECT r FROM Registration r WHERE r.name = ?1")
    public Registration findByName(String userName); 

	@Query("SELECT r FROM Registration r WHERE r.password = ?1")
    public Registration findByPassword(String password); 
	//public Registration findByResetPasswordToken(String token);

	public boolean existsByName(String name);
}
