package com.app.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AccommodationRequestDTO;
import com.app.security.FindUserDetails;
import com.app.service.AccommodationService;

@RestController
@RequestMapping("/user/accommodation")
@Validated
public class AccommodationController {
	 
	@Autowired
	private AccommodationService accoService;
	
	
	@Autowired
	private FindUserDetails authUserDetails;
	
	//ADD NEW ACCOMMODATION BOOKING
	//method=POST
	// http://localhost:8443/user/accommodation/add
	@PostMapping("/add")
	public ResponseEntity<?> addAccommodationBooking(@RequestBody
			@Valid AccommodationRequestDTO acco) {
		System.out.println("in add accommodation " + acco);
		Long userId = authUserDetails.getUserId();
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(accoService.addAccomodationBooking(acco,userId));
	}
	
	//GET PARTICULAR USER'S ACCOMMODATION BOOKINGS
	//method=GET
	// http://localhost:8443/user/accommodation/
	@GetMapping(value = "/")
	public ResponseEntity<?> getAccommodationBookingsByUser() throws IOException {
		Long userId = authUserDetails.getUserId();
		System.out.println("get accommodation bookings by user " + userId);
		return ResponseEntity.ok(accoService.getAllAccommodationBookingsByUserId(userId));
	}
	
	//CANCEL PARTICULAR USER'S ACCOMMODATION BOOKINGS
	//method=DELETE
    //http://localhost:8443/user/accommodation/{accommodationId}
	@DeleteMapping("/{accommodationId}")
	public ResponseEntity<?> deleteAccommodationDetails(@PathVariable Long accommodationId) {
		System.out.println("in update accommodation" + accommodationId);
		return ResponseEntity.ok(accoService.deleteAccomodationBookingById(accommodationId));
	}
	
	
	
	

	//GET ALL BOOKED DATES
	//method=GET
	//http://localhost:8443/user/accommodation/booked-dates
	@GetMapping("/booked-dates")
	public ResponseEntity<?> getAllAvailableDates()
	{
		System.out.println("Get All booked Accommodation Dates");
		return ResponseEntity.ok(accoService.getAllBookedDates());
	}

	
}
