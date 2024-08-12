package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.DonationRequestDTO;
import com.app.service.DonationService;

@RestController
@RequestMapping("/user/donation")
public class DonationController {
	
	@Autowired
	private DonationService donationService;
	
	@PostMapping("/add/{userId}")
	ResponseEntity<?> addDonation(@RequestBody @Valid DonationRequestDTO donation,@PathVariable Long userId){
		System.out.println("in add donation"+donation);
		
		return ResponseEntity.status(HttpStatus.CREATED).
				body(donationService.addDarshanBooking(donation, userId));
		
	}
	
	
	
	

}
