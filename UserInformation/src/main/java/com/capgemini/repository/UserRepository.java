package com.capgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.entities.UserDetails;

;

@Repository
public interface UserRepository extends JpaRepository<UserDetails, Long> {

}
