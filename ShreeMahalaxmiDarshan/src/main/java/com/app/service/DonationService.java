package com.app.service;

import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.DonationRequestDTO;
import com.app.dto.DonationResponseDTO;

public interface DonationService {
	
	ApiResponse addDarshanBooking(DonationRequestDTO donation,Long userId);

	List<DonationResponseDTO> getAllDonations();
}
