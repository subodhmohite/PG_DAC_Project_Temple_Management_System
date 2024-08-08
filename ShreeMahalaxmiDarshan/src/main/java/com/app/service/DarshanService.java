package com.app.service;

import com.app.dto.ApiResponse;
import com.app.dto.DarshanRequestDTO;

public interface DarshanService {

	//Add Darshan Booking
	ApiResponse addDarshanBooking(DarshanRequestDTO darshan,Long userId);
	
}
