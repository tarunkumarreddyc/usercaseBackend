package com.capgemini.services;


import com.capgemini.dto.Login;
import com.capgemini.exception.LoginNotFoundException;


public interface ILoginService {

	

public	String signIn(Login user) throws LoginNotFoundException;
}
