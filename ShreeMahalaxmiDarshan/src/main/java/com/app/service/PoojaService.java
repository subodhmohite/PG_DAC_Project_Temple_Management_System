
 package com.app.service;
  
 import java.time.LocalDate;
import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.PoojaRequestDTO;
import com.app.dto.PoojaResponseDTO;
  
 public interface PoojaService {
	 ApiResponse addPoojaBooking(PoojaRequestDTO pooja,Long userId);
	 
	 List<PoojaResponseDTO> getAllPoojaBookings();
	 
	 ApiResponse deletePoojaBookingById(Long poojaId);
	 
	 List<LocalDate> getAllBookedDates();
	 
	 List<String> getBookedPoojaTypeForTheDate(LocalDate date);

  
  
  
  }
 