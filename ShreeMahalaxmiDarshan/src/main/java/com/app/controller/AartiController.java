package com.app.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AartiRequestDTO;
import com.app.security.FindUserDetails;
import com.app.service.AartiService;

//http://localhost:8443/swagger-ui/index.html#/

@RestController
@RequestMapping("/user/aarti")
public class AartiController 
{
	@Autowired
	private AartiService artiService;
	
	@Autowired
	private FindUserDetails authUserDetails;
	
	//ADD NEW AARTI BOOKING 
	//method=POST
	// http://localhost:8443/user/aarti/add
	@PostMapping("/add")
	public ResponseEntity<?> addAartiBooking(@RequestBody
			@Valid AartiRequestDTO aarti) {
		Long userId = authUserDetails.getUserId();
		System.out.println("in add darshan " + aarti);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(artiService.addAartiBooking(aarti,userId));
	}
	

	//GET ALL AARTI BOKINGS BY THE USER
	//method=GET
	// http://localhost:8443/user/aarti/
	@GetMapping("/")
	public ResponseEntity<?> getAartiBookingsByUser() throws IOException {
		Long userId = authUserDetails.getUserId();
		System.out.println("get aarti bookings by user " + userId);
		return ResponseEntity.ok(artiService.getAllAartiBookingsByUserId(userId));
		
	}
	

	//CANCEL PARTICULAR USER'S AARTI BOOKINGS
	//method=DELETE
	// http://localhost:8443/user/aarti/{aartiId}
	@DeleteMapping("/{aartiId}")
	public ResponseEntity<?> cancelAartiBooking(@PathVariable Long aartiId)
	{
		System.out.println("In Delete Aarti: " + aartiId);
		return ResponseEntity.ok(artiService.deleteAartiBookingById(aartiId));
	}
	
	
}
