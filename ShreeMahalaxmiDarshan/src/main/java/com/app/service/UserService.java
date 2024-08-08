package com.app.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.app.dto.ApiResponse;
import com.app.dto.SigninDTO;
import com.app.dto.SignupDTO;
import com.app.dto.UserDTO;



public interface UserService {
	
	//User Signup
	SignupDTO userRegistration(SignupDTO regdto);
	
	
	//User Signin 
	UserDTO findUserByEmailAndPassword(SigninDTO dto);
	
	//Get User Profile By Id
	UserDTO getUserProfile(@PathVariable Long userid);
	
	//User update
	//UserDTO updateUserById(Long id,@Valid UserDTO updatedto);
	
	//Get All Users for Admin
	List<UserDTO> getAllUsers();
	
	//Delete User by Id For Admin
	ApiResponse deleteByUserId(@PathVariable Long userid);
	
	//Change Password
	//ApiResponse changePassword(SigninDTO dto,UserChangePasswordDTO passdto);
	

}
