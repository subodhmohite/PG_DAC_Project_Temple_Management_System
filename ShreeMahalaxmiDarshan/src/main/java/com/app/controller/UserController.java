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
import com.app.dto.UserDTO;
import com.app.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;

	
	/*
	 * @PostMapping("/signin") public ResponseEntity<?> userSignin(@RequestBody
	 * AuthDTO dto){ System.out.println("in userSign"+dto); try {
	 * 
	 * UserRespDTO respDto =userService.authenticateUser(dto); return
	 * ResponseEntity.ok(respDto); }catch(RuntimeException e) {
	 * System.out.println(e); return ResponseEntity.status(HttpStatus.NOT_FOUND)
	 * .body(new ApiResponse(e.getMessage())); }
	 */
	
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
