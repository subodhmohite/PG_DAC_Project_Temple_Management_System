package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	//Get User Profile By ID
	//METHOD = GET
	//http://localhost:8080/user/my-profile/{userid}
	@GetMapping("/my-profile/{userid}") 
	public ResponseEntity<?> showUserDetails(@PathVariable Long userid){
	  System.out.println("in show User details"+userid); 
	  return ResponseEntity.ok(userService.getUserProfile(userid)); 
	  }
	 
	 
	 
	
	/*
	 * //Update User Profile
	 * 
	 * @PutMapping("/my-profile/update-user") public ResponseEntity<?>
	 * updateUserDetails(@RequestBody @Valid UserDTO dto){ Long userId =
	 * dto.getId(); System.out.println("in update user"+userId+" "+dto); return
	 * ResponseEntity.ok(userService.updateUserById(userId, dto)); }
	 */
	  
			
		
	

}
