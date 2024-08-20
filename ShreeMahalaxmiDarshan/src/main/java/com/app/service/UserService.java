package com.app.service;

import java.util.List;

import javax.validation.Valid;

import com.app.dto.ApiResponse;
import com.app.dto.OtpDTO;
import com.app.dto.ResetPassword;
import com.app.dto.Signup;
import com.app.dto.UserChangePasswordDTO;
import com.app.dto.UserDTO;

public interface UserService {
//sign up
	Signup userRegistration(Signup reqDTO);


	UserDTO updateUser(Long userId, @Valid UserDTO dto);


	UserDTO getUserProfile(Long userId);


	ApiResponse deleteUserDetails(Long userId);


	ApiResponse changeUserPassword(Long userId, UserChangePasswordDTO dto);


	List<UserDTO> getAllUsers();
	
	ApiResponse forgotPassword(String email);
	
	OtpDTO verifyOtp(OtpDTO userRequest);
	
	ApiResponse resetPassword(ResetPassword object);
}
