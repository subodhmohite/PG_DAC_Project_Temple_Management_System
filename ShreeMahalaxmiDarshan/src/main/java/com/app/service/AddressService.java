package com.app.service;

import javax.validation.Valid;

import com.app.dto.AddressRequestDTO;
import com.app.dto.AddressResponseDTO;

public interface AddressService {

	AddressResponseDTO updateAddress(Long userId, @Valid AddressRequestDTO dto);

	AddressResponseDTO asssignAddress(Long userId, @Valid AddressRequestDTO dto);

	AddressResponseDTO getAddressDetails(Long userId);
}
