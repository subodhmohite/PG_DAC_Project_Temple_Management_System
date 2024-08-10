package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.SigninDTO;
import com.app.dto.SignupDTO;
import com.app.dto.UserDTO;
import com.app.service.UserService;

@RestController
@RequestMapping("/users")
public class UserSignupSigninController {
	
	@Autowired
	private UserService userService;
	
	
	//For User Registration
	//METHOD = GET
	//http://localhost:8080/users/sigup
	@PostMapping("/signup")
	public ResponseEntity<?> userSignup(@RequestBody SignupDTO signupdto){
		System.out.println("in signup"+signupdto);
		if(signupdto.getConfirmpassword().equals(signupdto.getPassword()))
		{
			return ResponseEntity.status(HttpStatus.CREATED).body(userService.userRegistration(signupdto));
		}
		else
		{
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ApiResponse("Password do not match.."));
		}
	}

	//For User Login
	//METHOD = GET
	//http://localhost:8080/users/signin
	@PostMapping("/signin")
	public ResponseEntity<?> userSignin(@RequestBody SigninDTO dto ){
		System.out.println("in userSignin"+dto);
		try {
			UserDTO respDto =userService.findUserByEmailAndPassword(dto);
			return ResponseEntity.ok(respDto);
		}catch(RuntimeException e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ApiResponse(e.getMessage()));
		}
	}
	
			
	

}
