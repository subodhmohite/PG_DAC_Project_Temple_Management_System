
 package com.app.controller;
  
import java.time.LocalDate;
import java.util.List;

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

import com.app.dto.PoojaRequestDTO;
import com.app.service.PoojaService;
  
@RestController
@RequestMapping("/user/pooja")

public class PoojaController {
	
	@Autowired 
	private PoojaService poojaService;
	
	@PostMapping("/add/{userId}")
	public ResponseEntity<?> addPoojaBooking(@RequestBody @Valid PoojaRequestDTO pooja,@PathVariable Long userId){ 
		System.out.println("in add pooja"+userId); 
		return ResponseEntity.status(HttpStatus.CREATED).
				body(poojaService.addPoojaBooking(pooja, userId)); 
		}
	

	@DeleteMapping("/{poojaId}")
	public ResponseEntity<?> cancelPoojaBooking(@PathVariable Long poojaId) {
		
		System.out.println("in cancel Pooja Booking " + poojaId);
		return ResponseEntity.ok(poojaService.deletePoojaBookingById(poojaId));
	}
	
	@GetMapping("/get-booked-dates")
	public List<LocalDate> getBookedDates()
	{
		return poojaService.getAllBookedDates();
	}
	
	@GetMapping("/get-booked-type/{date}")
	public ResponseEntity<?> getBookedPoojaTypeForDate(@PathVariable String date){
		System.out.println("in booked dates"+date);
		try {
			
			LocalDate lDate = LocalDate.parse(date);//Parse the String to LocalDate
			System.out.println("Parsed LocalDate:"+lDate);
			
			return ResponseEntity.ok(poojaService.getBookedPoojaTypeForTheDate(lDate));
			
		}catch(Exception e) {
			System.out.println("Error while Parsing date:");
			return ResponseEntity.badRequest().body(e.getMessage());
			
		}
	}
 
	
  }
 