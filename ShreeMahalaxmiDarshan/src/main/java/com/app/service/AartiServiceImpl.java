package com.app.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.app.customexception.ResourceNotFoundException;
import com.app.dto.AartiRequestDTO;
import com.app.dto.AartiResponseDTO;
import com.app.dto.ApiResponse;
import com.app.entities.Aarti;
import com.app.entities.UserEntity;
import com.app.repository.AartiDao;
import com.app.repository.UserDao;

@Service
@Transactional

public class AartiServiceImpl implements AartiService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private AartiDao aartiDao;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public ApiResponse addAartiBooking(AartiRequestDTO aarti, Long userId) {
		UserEntity curUser= userDao.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Invalid userId"));
		Aarti aartiEntity = mapper.map(aarti, Aarti.class);
		
		
		List<Aarti> list = aartiDao.findByAartiDateAndAartiType(aarti.getAartiDate(),aarti.getAartiType());
		
		int noOfPersonsByDateAndType = list.stream()
									   .mapToInt(Aarti::getNoOfPerson)
									   .sum();
		
		if(noOfPersonsByDateAndType + aarti.getNoOfPerson() > 5)
			return new ApiResponse("No Booking Available For the TimeSlot on The Date You Asking ---");
		
		aartiEntity.setUser(curUser);
		aartiEntity.setDevoteename(curUser.getFirstname()+" "+curUser.getLastname());
		aartiEntity.setAadhaarno(curUser.getAadhaarno());
		
		Aarti persistentEntity = aartiDao.save(aartiEntity);
		System.out.println(persistentEntity);
			
		return new ApiResponse("Aarti Booking Successfully done for given Time");

		
	}

	@Override
	public List<AartiResponseDTO> getAllAartiBookings() {
		Sort sortByDate = Sort.by(Sort.Direction.ASC, "aartiDate");
		List<Aarti> aartiSortedList = aartiDao.findAll(sortByDate);
		return aartiSortedList.stream()
				.map(aarti -> mapper.map(aarti, AartiResponseDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public ApiResponse deleteAartiBookingById(Long aartiId) {

		Aarti aarti = aartiDao.findById(aartiId).
				orElseThrow(() -> new ResourceNotFoundException("Invalid emp id"));
		
		LocalDate currentDate = LocalDate.now();
		
		long differenceInDays = java.time.temporal.ChronoUnit.DAYS.between(currentDate, aarti.getAartiDate());
		
		if(differenceInDays >= 7)
		{
			aartiDao.delete(aarti);
			return new ApiResponse("Aarti Details of aarti with ID " + aarti.getId() + " cancelled....");
			
		}
		else {
			return new ApiResponse("Aarti can't be cancelled as the buffer limit of 7 days has crossed....");
		}
	}

}
