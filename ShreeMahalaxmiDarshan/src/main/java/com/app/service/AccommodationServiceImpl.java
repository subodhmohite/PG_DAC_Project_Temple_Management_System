package com.app.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_Exceptions.ResourceNotFoundException;
import com.app.dao.AccommodationDao;
import com.app.dao.UserEntityDao;
import com.app.dto.AccommodationRequestDTO;
import com.app.dto.AccommodationResponseDTO;
import com.app.dto.ApiResponse;
import com.app.entities.Accommodation;

import com.app.entities.Darshan;

import com.app.entities.UserEntity;

@Service
@Transactional
public class AccommodationServiceImpl implements AccommodationService {
	@Autowired
	private AccommodationDao accodao;
	
	@Autowired
	private UserEntityDao userDao; 
	
	@Autowired
	private ModelMapper mapper;
	
	
	@Override
	public ApiResponse addAccomodationBooking(AccommodationRequestDTO acco,Long userId) {

		
		
		UserEntity curUser = userDao.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Invalid User"));

		List<Accommodation> list = accodao.findByCheckInDate(acco.getCheckInDate());

		int noOfRoomsBooksByDate = list.stream()
				.mapToInt(Accommodation::getNumberOfRooms)
				.sum();
		if(noOfRoomsBooksByDate+acco.getNumberOfRooms()> 3)
			return new ApiResponse("No booking avilable on given date");
		Accommodation accoEntity = mapper.map(acco, Accommodation.class);
		accoEntity.setUser(curUser);
		accoEntity.setPrimaryDevoteeName(curUser.getFirstName() + " " + curUser.getLastName());
		accoEntity.setAdharNo(curUser.getAdharNumber());
		Accommodation persistentAcco = accodao.save(accoEntity);

		return new ApiResponse("Room booking successfully done. with ID " + persistentAcco.getId());
	}
		

	@Override
	public List<AccommodationResponseDTO> getAllAccommodationBookingsByUserId(Long userId) {
		
		List<Accommodation> accoList = accodao.findByUserId(userId);
		return accoList.stream().map(acco -> mapper.map(acco, AccommodationResponseDTO.class)).collect(Collectors.toList());

	}

	@Override
	public ApiResponse deleteAccomodationBookingById(Long id) {
		Accommodation acco = accodao.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("Invalid emp id"));
		
		LocalDate currentDate = LocalDate.now();
		
		long differenceInDays = java.time.temporal.ChronoUnit.DAYS.between(currentDate, acco.getCheckInDate());

		if(differenceInDays >= 15)
		{
			accodao.delete(acco);
			return new ApiResponse("Accommodation Details of accommodation with Id" + acco.getId() + " deleted....");
		}
		else
			return new ApiResponse("Accommodation can't be cancelled as the buffer limit of 15 days has crossed....");
		
		
	}
	
	
	@Override
	public List<AccommodationResponseDTO> getAllAccommodationBookings() {
		
		
		List<Accommodation> sortedListByCheckInDate = accodao.findAllByOrderedByCheckInDateAsc();
		return sortedListByCheckInDate.stream()
				.map(accommodation -> mapper.map(accommodation, AccommodationResponseDTO.class))
				.collect(Collectors.toList());
	}

	
	
	
	


	@Override
	public List<LocalDate> getAllBookedDates() {
		
		return accodao.findAllCheckInDates();
	}
	

//	@Override
//	public void incrementCounter(Accommodation acco) {
//		List<Accommodation> accoList = accodao.findByCheckInDate(acco.getCheckInDate());
//
//		if(!accoList.isEmpty()) {
//		//Accommodation ac = accoList.get(0);
//		accoList.forEach(a -> a.setRoomCounter(a.getRoomCounter()+1));
//		}
//		else 
//			acco.setRoomCounter(1);
//		
//		//return acco.getRoomCounter();
//		
//
//	}
//	
//	@Override
//	public void decrementCounter(Accommodation acco) {
//		List<Accommodation> accoList = accodao.findByCheckInDate(acco.getCheckInDate());
//		System.out.println(accoList.toString());
//		//Accommodation ac = accoList.get(0);
//		accoList.forEach(a -> a.setRoomCounter(a.getRoomCounter()-1));
//		//return ac.getRoomCounter();
//		
//	}
	
	
//	@Override
//	public List<LocalDate> getAllAvailableDates() {
//		return accodao.findCheckInDatesByRoomCounter();
//	}

//	@Override
//	public Integer getRoomCounterByDate(LocalDate date) {
//		Integer a =accodao.findRoomCounterByCheckInDate(date);
//		
//		if(a==null)
//			return 0;
//		else
//		return a;
//	}

}



