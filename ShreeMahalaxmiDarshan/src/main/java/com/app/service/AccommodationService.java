package com.app.service;

import java.time.LocalDate;
import java.util.List;

import com.app.dto.AccommodationRequestDTO;
import com.app.dto.AccommodationResponseDTO;
import com.app.dto.ApiResponse;
import com.app.entities.Accommodation;

public interface AccommodationService {
	ApiResponse addAccomodationBooking(AccommodationRequestDTO acco,Long userId);
	
	List<AccommodationResponseDTO> getAllAccommodationBookingsByUserId(Long userId);
	
	ApiResponse deleteAccomodationBookingById(Long id);
	List<AccommodationResponseDTO> getAllAccommodationBookings();
	
	
	
	List<LocalDate> getAllBookedDates();
	
//	Integer getRoomCounterByDate(LocalDate date);
	
//	void incrementCounter(Accommodation acco);
//	
//	void decrementCounter(Accommodation acco);
	
//	List<LocalDate> getAllAvailableDates();
}
