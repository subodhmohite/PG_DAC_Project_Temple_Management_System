package com.app.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

import com.app.dto.DarshanRequestDTO;
import com.app.security.FindUserDetails;
import com.app.service.DarshanService;


@RestController
@RequestMapping("/user/darshan")
@Validated


public class DarshanController {
	
	@Autowired
	private DarshanService darshanService;
	
	@Autowired
	private FindUserDetails authUserDetails;
	
	//ADD NEW DARSHAN BOOKING
	//method=POST
	// https://localhost:8443/user/darshan/add
	@PostMapping("/add")
	public ResponseEntity<?> addDarshanBooking(@RequestBody
			@Valid DarshanRequestDTO darshan) {	
		Long userId = authUserDetails.getUserId();
		System.out.println("in add darshan " + darshan);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(darshanService.addDarshanBooking(darshan,userId));
	}
	
	
	//GET PARTICULAR USER'S DARSHAN BOOKINGS
	//method=GET
	// https://localhost:8443/user/darshan/
	@GetMapping(value = "/")
	public ResponseEntity<?> getDarshanBookingsByUser() throws IOException 
	{
		Long userId = authUserDetails.getUserId();
		System.out.println("get darshan bookings by user " + userId);
		return ResponseEntity.ok(darshanService.getAllDarshanBookingsByUserId(userId));	
	}
	
	//CANCEL PARTICULAR USER'S DARSHAN BOOKINGS
	//method=DELETE
	// https://localhost:8443/user/darshan/{darshanId}
	@DeleteMapping("/{darshanId}")
	public ResponseEntity<?> cancelDarshanBooking(@PathVariable Long darshanId) 
	{
		
		
		System.out.println("in delete darshan " + darshanId);
		return ResponseEntity.ok(darshanService.deleteDarshanBookingById(darshanId));
	}
	

	//GET ALL BOOKED DATES i.e. UNAVAILABLE DATES
	//method: GET
	// https://localhost:8443/user/darshan/booked-timeslots/{date}
	@GetMapping("/booked-timeslots/{date}")
	public ResponseEntity<?> getAllBookedTimeSlotsByDate(@PathVariable String date) {
		System.out.println("date:" + date);
        // Define the date formatter (optional, but recommended)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {
            // Parse the string to LocalDate
            LocalDate lDate = LocalDate.parse(date, formatter);
         // Print the LocalDate
            System.out.println("Parsed LocalDate: " + lDate);
         
            return ResponseEntity.ok(darshanService.getAllBookedTimeSlotsByDate(lDate));
            
        } catch (Exception e) {
            // Handle parsing exception
            System.out.println("Error parsing date: " + e.getMessage());
            return null;
        }
	}

	
	//GET ALL BOOKED DATES i.e. UNAVAILABLE DATES
	//method: GET
	// https://localhost:8443/user/darshan/booked-dates
	@GetMapping("/booked-dates")
	public ResponseEntity<?> getAllBookedDates() {
		return ResponseEntity.ok(darshanService.getAllBookedDates());
	}

}
