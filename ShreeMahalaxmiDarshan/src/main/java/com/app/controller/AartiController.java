package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AartiRequestDTO;
import com.app.service.AartiService;

@RestController
@RequestMapping("/user/aarti")
public class AartiController {
	
	@Autowired
	private AartiService aartiService;
	
	@PostMapping("/add/{userId}")
	ResponseEntity<?> addAartiBooking(@RequestBody AartiRequestDTO aarti,@PathVariable Long userId){
		System.out.println("in aarti Booking");
		
		return ResponseEntity.status(HttpStatus.CREATED).body(aartiService.addAartiBooking(aarti, userId));
	}
	
	@DeleteMapping("/{aartiId}")
	ResponseEntity<?> cancelAartiBooking(@PathVariable Long aartiId){
		System.out.println("in cancel booking"+ aartiId);
		return ResponseEntity.ok(aartiService.deleteAartiBookingById(aartiId));
	}
	
	

}
