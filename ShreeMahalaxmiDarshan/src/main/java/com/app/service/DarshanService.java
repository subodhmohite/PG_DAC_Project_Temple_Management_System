package com.app.service;

import java.time.LocalDate;
import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.DarshanRequestDTO;
import com.app.dto.DarshanResponseDTO;

public interface DarshanService {

	//Add Darshan Booking
	ApiResponse addDarshanBooking(DarshanRequestDTO darshan,Long userId);
	
	//List of All Darshan Booking For ADMIN
	List<DarshanResponseDTO> getAllDarshanBookings();
	
	//List of Darshan Booking By UserId
	//List<DarshanResponseDTO> getAllDarshanBookingsByUserId(Long userId);
	
	//Cancel Darshan By Darshan Id 
	ApiResponse deleteDarshanBookingById(Long darshanId);
	
	//List of Darshan Booked by Time and Date Slots
	List<String> getAllBookedTimeSlotsByDate(LocalDate bookingDate);
	
	//List of All Booked Dates By No of Person >=100 
	List<LocalDate> getAllBookedDates();
}
