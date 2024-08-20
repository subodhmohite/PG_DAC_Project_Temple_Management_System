package com.app.service;

import java.time.LocalDate;
import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.DarshanRequestDTO;
import com.app.dto.DarshanResponseDTO;
import com.app.entities.TimeEnum;


public interface DarshanService {
	
	ApiResponse addDarshanBooking(DarshanRequestDTO darshan,Long userId);
	
	List<DarshanResponseDTO> getAllDarshanBookingsByUserId(Long userId);
	
	ApiResponse deleteDarshanBookingById(Long id);
	
	//Integer incrementCounter(Long bookingDateId,Long timeSlotId);

	List<DarshanResponseDTO> getAllDarshanBookings();
	
	List<String> getAllBookedTimeSlotsByDate(LocalDate bookingDate);

	List<LocalDate> getAllBookedDates();


	//List<TimeEnum> getAllAvailableTimeSlotsByDate(LocalDate bookingDate);


}

