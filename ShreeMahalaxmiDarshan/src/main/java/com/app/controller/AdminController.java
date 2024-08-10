package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.DarshanService;
import com.app.service.UserService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private DarshanService darshanService;
	
	//Get All Users
	//method= GET
	// https://localhost:8080/admin/all-users
	@GetMapping("/all-users")
	public ResponseEntity<?> getAllUsers(){
		System.out.println("in get All Users");
		return ResponseEntity.ok(userService.getAllUsers());
	}
	
	//Delete User By Id
	//method= DELETE
	//https://localhost:8080/admin/all-users/{userid}
	@DeleteMapping("/all-users/{userid}")
	public ResponseEntity<?> deleteUserById(Long userid){
		System.out.println("in User Delete");
		return ResponseEntity.ok(userService.deleteByUserId(userid));
		
	}
	
	//Get All Darshan Bookings
	//METHOD=GET
	//https://localhost:8080/admin/all-darshan
	@GetMapping("/all-darshan")
	public ResponseEntity<?> getAllDarshan(){
		System.out.println("in get All Darshan Bookings");
		return ResponseEntity.ok(darshanService.getAllDarshanBookings());
	}

}
