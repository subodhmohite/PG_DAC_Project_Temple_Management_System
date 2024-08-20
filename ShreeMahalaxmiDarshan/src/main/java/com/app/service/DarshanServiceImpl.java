package com.app.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_Exceptions.ResourceNotFoundException;

import com.app.dao.DarshanDao;

import com.app.dao.UserEntityDao;
import com.app.dto.ApiResponse;
import com.app.dto.DarshanRequestDTO;
import com.app.dto.DarshanResponseDTO;

import com.app.entities.Darshan;
import com.app.entities.TimeEnum;

import com.app.entities.UserEntity;

@Service
@Transactional
public class DarshanServiceImpl implements DarshanService {
	

	@Autowired
	private DarshanDao darshanDao;
	
	
//	@Autowired
//	private TimeSlotDao timeSlotDao;
//	
//	@Autowired
//	private BookingDateDao bookingDateDao;
	
	
	@Autowired
	private UserEntityDao userDao; 

	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public ApiResponse addDarshanBooking(DarshanRequestDTO darshan,Long userId) {
		UserEntity curUser= userDao.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Inavalid userId"));
		Darshan darshanEntity=  mapper.map(darshan, Darshan.class);
		
		List<Darshan> list = darshanDao.findByBookingDateAndTimeSlot(darshanEntity.getBookingDate(),darshanEntity.getTimeSlot());
		
		int noOfPersonsByDateAndTimeslot = list.stream()
				.mapToInt(Darshan::getPersons)
				.sum();
		
		if(noOfPersonsByDateAndTimeslot + darshan.getPersons()> 5)
			return new ApiResponse("No Booking available for Timeslot --" + darshanEntity.getTimeSlot());
		darshanEntity.setUser(curUser);
		darshanEntity.setPrimaryDevoteeName(curUser.getFirstName()+" "+curUser.getLastName());
		darshanEntity.setAdharNo(curUser.getAdharNumber());
		
		Darshan persistentDarshan = darshanDao.save(darshanEntity);
		return new ApiResponse("Darshan booking successfully done for given slot");
	}

	@Override

	public List<DarshanResponseDTO> getAllDarshanBookingsByUserId(Long userId) {

	
		List<Darshan> darshanList = darshanDao.findByUserId(userId);
		return darshanList.stream().map(darshan -> mapper.map(darshan, DarshanResponseDTO.class)).collect(Collectors.toList());
	}

	@Override
	public ApiResponse deleteDarshanBookingById(Long darshanId) {

		
		Darshan darshan = darshanDao.findById(darshanId).
				orElseThrow(() -> new ResourceNotFoundException("Invalid darshan id"));
		
		
		LocalDate currentDate = LocalDate.now();
		
		long differenceInDays = java.time.temporal.ChronoUnit.DAYS.between(currentDate, darshan.getBookingDate());

		if(differenceInDays >= 15)
		{	
			darshanDao.delete(darshan);
			return new ApiResponse("Darshan Details of dasrhan with ID " + darshan.getId() + " cancelled....");
		}
		
		else 
			return new ApiResponse("Darshan can't be cancelled as the buffer limit of 15 days has crossed....");
			
	}

	
	

	public List<DarshanResponseDTO> getAllDarshanBookings() {
		
		Sort sortByDate = Sort.by(Sort.Direction.ASC, "bookingDate"); // Sort by the 'date' property in ascending order
		List<Darshan> list= darshanDao.findAll(sortByDate);
		return list.stream().map(darshan -> mapper.map(darshan, DarshanResponseDTO.class)).collect(Collectors.toList());
	}

	@Override
	public List<String> getAllBookedTimeSlotsByDate(LocalDate bookingDate) {
		 List<TimeEnum> timeslots = darshanDao.findAllTimeSlotsByBookingDate(bookingDate);
		
		 return  timeslots.stream().map(t->t.toString()).collect(Collectors.toList());
		 
	}

	@Override
	public List<LocalDate> getAllBookedDates() {
		return darshanDao.findAllBookingDatesByPersons();
	}
		


	
//	@Override
//	public List<TimeEnum> getAllAvailableTimeSlotsByDate(LocalDate bookingDate) {
//		
//		return darshanDao.FindTimeSlotsByBookingDateAndCounter(bookingDate);
//	}
//	
//	
	
	
//	@Override
//	public Integer incrementCounter(Long timeSlotId, Long bookingDateId) {
//		List<Darshan> darshanList = darshanDao.findByBookingDateAndTimeSlot(bookingDateId, timeSlotId);
//		Darshan d = darshanList.get(0);
//		if(d.counter == null)
//			darshanList.stream().map(darshan -> darshan.counter = 0);
//		else
//		    darshanList.stream().map(darshan -> darshan.counter ++);
//		return d.counter;
//	}




	



	

	

}
