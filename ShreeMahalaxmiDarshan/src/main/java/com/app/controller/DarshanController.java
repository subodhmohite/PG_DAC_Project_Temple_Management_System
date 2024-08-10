package com.app.controller;

import java.time.LocalDate;

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
import com.app.service.DarshanService;

@RestController
@RequestMapping("/user/darshan")
@Validated
public class DarshanController {
	
	@Autowired
	private DarshanService darshanService;
	
	//Book Darshan For User (By userid) 
	//METHOD = POST
	//http://localhost:8080/user/darshan/add/{userId}
	@PostMapping("/add/{userId}")
	public ResponseEntity<?> addDarshanBooking(@RequestBody @Valid DarshanRequestDTO darshan,@PathVariable Long userId){
		System.out.println("in add darshan"+ darshan);
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(darshanService.addDarshanBooking(darshan, userId));
	}
	
	/*
	 * @GetMapping("/{userId}/darshanList") public ResponseEntity<?>
	 * getAllDarshanByUserId(@PathVariable Long userId){
	 * System.out.println("in get all darshan by userid"+ userId);
	 * List<DarshanResponseDTO> darshanList =
	 * darshanService.getAllDarshanBookingsByUserId(userId); return
	 * ResponseEntity.ok(darshanList); }
	 */
	
	//Cancel Booked Darshan By User (By darshanid) 
	//METHOD = DELETE
	//http://localhost:8080/user/darshan/{darshanid}
	@DeleteMapping("/{darshanid}")
	public ResponseEntity<?> cancelDarshanBooking(@PathVariable Long darshanid){
		System.out.println("in cancel darshan");
		return ResponseEntity.ok(darshanService.deleteDarshanBookingById(darshanid));
	}
	
	//Get All TimeSlots of Date i.e. UNAVAILABLE TIMESLOTS
	//METHOD=GET
	// https://localhost:8443/user/darshan/booked-timeslots/{date}
	@GetMapping("/booked-timeslots/{date}")
	public ResponseEntity<?> getAllBookedTimeSlotsByDate(@PathVariable String date){
		System.out.println("in booked dates"+date);
		try {
			
			LocalDate lDate = LocalDate.parse(date);//Parse the String to LocalDate
			System.out.println("Parsed LocalDate:"+lDate);
			
			return ResponseEntity.ok(darshanService.getAllBookedTimeSlotsByDate(lDate));
			
		}catch(Exception e) {
			System.out.println("Error while Parsing date:");
			return ResponseEntity.badRequest().body(e.getMessage());
			
		}
	}
	
	//Get All Booked Dates i.e. UNAVAILABLE DATES
	//METHOD=GET
	//https://localhost:8080/user/darshan/booked-dates
	@GetMapping("/booked-dates")
	public ResponseEntity<?> getAllBookedDates(){
		return ResponseEntity.ok(darshanService.getAllBookedDates());
	}
	
}
	