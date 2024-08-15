package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.customexception.ResourceNotFoundException;
import com.app.dto.ApiResponse;
import com.app.dto.DonationRequestDTO;
import com.app.dto.DonationResponseDTO;
import com.app.entities.Donation;
import com.app.entities.UserEntity;
import com.app.repository.DonationDao;
import com.app.repository.UserDao;

@Service
@Transactional
public class DonationServiceImpl implements DonationService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired 
	private DonationDao donationDao;
	
	@Autowired
	private ModelMapper mapper;
	

	@Override
	public ApiResponse addDarshanBooking(DonationRequestDTO donation, Long userId) {
		UserEntity curUser=userDao.findById(userId).
				orElseThrow(()-> new ResourceNotFoundException("Invalid userId"));
		Donation donationEntity =mapper.map(donation,Donation.class);
		
		donationEntity.setUser(curUser);
		donationEntity.setDname(curUser.getFirstname());
		donationEntity.setDlastname(curUser.getLastname());
		donationEntity.setAadhaarno(curUser.getAadhaarno());
		donationDao.save(donationEntity);
		
		return new ApiResponse("Donation Done successfully");
	}


	@Override
	public List<DonationResponseDTO> getAllDonations() {
		Sort sortByDate = Sort.by(Sort.Direction.ASC,"ddate");//Sort by the 'ddate' property in ascending order
		List<Donation> list =donationDao.findAll(sortByDate);
		return list.stream().map(donation-> mapper.map(donation,DonationResponseDTO.class)).collect(Collectors.toList());
	}

}



