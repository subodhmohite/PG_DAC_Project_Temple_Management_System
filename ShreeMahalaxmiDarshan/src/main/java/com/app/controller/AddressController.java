package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AddressRequestDTO;
import com.app.security.FindUserDetails;
import com.app.service.AddressService;

@RestController
@RequestMapping("/user/my-profile/address")
public class AddressController {

	@Autowired
	private AddressService addrService;
	
	@Autowired
	private FindUserDetails authUserDetails;
	
	//GET USER'S ADDRESS
		//method=get
		//http://localhost:8443/user/my_profile/address 
		//update the url according to front end
		@GetMapping
		public ResponseEntity<?> getUserAddress() {
			
			Long userId = authUserDetails.getUserId();
			System.out.println("in update user " + userId);
			return ResponseEntity.ok(addrService.getAddressDetails(userId));
			
		}
	
		//ASSIGN AN ADDRESS TO THE USER
	    //method=Post
		// http://localhost:8443/user/my_profile/address/add_address
		//update the url according to front end

		
			@PostMapping("/add-address")
			public ResponseEntity<?> assignUserAddress( @RequestBody @Valid AddressRequestDTO dto) {
			Long userId = authUserDetails.getUserId();

				System.out.println("in update user " + userId + " " + dto);
				return ResponseEntity.ok(addrService.asssignAddress(userId, dto));
			}
	
	
	//UPDATE USER'S ADDRESS
	//method=PUT
	 // http://localhost:8443/user/my_profile/address/update_address
	//update the url according to front end

	
		@PutMapping("/update-address")
		public ResponseEntity<?> updateUserAddress(@RequestBody @Valid AddressRequestDTO dto) 
		{
			Long userId = authUserDetails.getUserId();

			System.out.println("in update user " + userId + " " + dto);
			return ResponseEntity.ok(addrService.updateAddress(userId, dto));
		}
	
}
