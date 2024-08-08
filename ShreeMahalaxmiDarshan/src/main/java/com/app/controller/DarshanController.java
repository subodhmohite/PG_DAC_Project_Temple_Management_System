package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
	
	@PostMapping("/add/{userId}")
	public ResponseEntity<?> addDarshanBooking(@RequestBody @Valid DarshanRequestDTO darshan,@PathVariable Long userId){
		System.out.println("in add darshan"+ darshan);
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(darshanService.addDarshanBooking(darshan, userId));
	}

}
