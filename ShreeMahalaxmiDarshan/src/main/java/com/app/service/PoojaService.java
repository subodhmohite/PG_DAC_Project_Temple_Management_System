package com.app.service;

import java.time.LocalDate;
import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.PoojaRequestDTO;
import com.app.dto.PoojaResponseDTO;
import com.app.entities.PoojaType;

public interface PoojaService {
	
	ApiResponse addPoojaBooking(PoojaRequestDTO darshan,Long userId);
	
	List<PoojaResponseDTO> getAllPoojaBookingsByUserId(Long poojaId);

	ApiResponse deletePoojaBookingById(Long poojaId);

	List<PoojaResponseDTO> getAllPoojaBookings();
	
	List<LocalDate> getAllBookedDates();

	List<String> getBookedPoojaTypeForTheDate(LocalDate date);

}
