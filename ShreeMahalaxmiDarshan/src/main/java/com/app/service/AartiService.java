package com.app.service;

import java.time.LocalDate;
import java.util.List;

import com.app.dto.AartiRequestDTO;
import com.app.dto.AartiResponseDTO;
import com.app.dto.ApiResponse;

public interface AartiService {
	
	ApiResponse addAartiBooking(AartiRequestDTO aarti,Long userId);
	
	ApiResponse deleteAartiBookingById(Long id);
	
	List<AartiResponseDTO> getAllAartiBookings();
	
	List<LocalDate> getAllBookedDates();

}
