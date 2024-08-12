package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.AartiService;
import com.app.service.DarshanService;
import com.app.service.DonationService;
import com.app.service.PoojaService;
import com.app.service.UserService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private DarshanService darshanService;
	
	@Autowired
	private PoojaService poojaService;
	
	@Autowired
	private AartiService aartiService;
	
	@Autowired
	private DonationService donationService;
	
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

	//Get All Pooja Bookings
	//METHOD=GET
	//https://localhost:8080/admin/all-pooja
	@GetMapping("/all-pooja")
	public ResponseEntity<?> getAllPooja(){
		System.out.println("in get all Pooja Bookings");
		return ResponseEntity.ok(poojaService.getAllPoojaBookings());
	}
	
	//Get All Aarti Bookings
	//METHOD=GET
	//https://localhost:8080/admin/all-aarti
	@GetMapping("/all-aarti")
	public ResponseEntity<?> getAllAarti(){
		System.out.println("in get all Aarti Bookings");
		return ResponseEntity.ok(aartiService.getAllAartiBookings());
	}
	
	//Get All Donations
	//METHOD=GET
	//https://localhost:8080/admin/all-donation
	@GetMapping("/all-donation")
	public ResponseEntity<?> getAllDonation(){
		System.out.println("in get all Donations");
		return ResponseEntity.ok(donationService.getAllDonations());
	}
}
