package com.app.service;

import com.app.dto.*;



public interface UserService {
	
	//User Signup
	SignupDTO userRegistration(SignupDTO regdto);
	
	
	//User Signin 
	UserDTO findUserByEmailAndPassword(SigninDTO dto);
	
	

}
