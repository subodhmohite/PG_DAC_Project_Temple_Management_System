package com.app.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.customexception.ResourceNotFoundException;
import com.app.dto.ApiResponse;
import com.app.dto.DarshanRequestDTO;
import com.app.dto.DarshanResponseDTO;
import com.app.entities.Darshan;
import com.app.entities.TimeSlot;
import com.app.entities.UserEntity;
import com.app.repository.DarshanDao;
import com.app.repository.UserDao;

@Service
@Transactional
public class DarshanServiceImpl implements DarshanService {
	
	@Autowired
	private DarshanDao darshanDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ModelMapper mapper;

	//Add Darshan By Id
	@Override
	public ApiResponse addDarshanBooking(DarshanRequestDTO darshan, Long userId) {
		
		
		UserEntity curUser=userDao.findById(userId).
				orElseThrow(()-> new ResourceNotFoundException("Invalid userId"));
		Darshan darshanEntity =mapper.map(darshan,Darshan.class);
		
		List<Darshan> list = darshanDao.findUserByBookingDateAndTimeSlot(darshanEntity.getBookingDate(), darshanEntity.getTimeSlot());
		
		int noofPersonsByDateAndTimeSlot = list.stream()
				.mapToInt(Darshan::getNoofperson)
				.sum();
		if(noofPersonsByDateAndTimeSlot + darshan.getNoofperson()>5)
			return new ApiResponse("No Booking available for TimeSlot --" + darshanEntity.getTimeSlot());
		darshanEntity.setUserid(curUser);
		darshanEntity.setDevoteename(curUser.getFirstname()+" "+curUser.getLastname());
		darshanEntity.setAddharno(curUser.getAddharno());
		darshanDao.save(darshanEntity);
		
		return new ApiResponse("Darshan Booking successfully Done For given Slot");
		
	}

	//List Of All Darshan Bookings For ADMIN (Sort By Date remaining)
	@Override
	public List<DarshanResponseDTO> getAllDarshanBookings() {
		List<Darshan> list = darshanDao.findAll();
		return list.stream().map(darshan -> mapper.map(darshan,DarshanResponseDTO.class)).collect(Collectors.toList());
	}

	//Cancel the Darshan booking By User before 7 days of booked Date
	@Override
	public ApiResponse deleteDarshanBookingById(Long darshanId) {
		Darshan darshan=darshanDao.findById(darshanId)
				.orElseThrow(()-> new ResourceNotFoundException("Invalid Darshan Id"));
		
		LocalDate currentDate = LocalDate.now();
		
		long differenceInDays = java.time.temporal.ChronoUnit.DAYS.between(currentDate, darshan.getBookingDate());
		
		if(differenceInDays >= 7) {
			darshanDao.delete(darshan);
			return new ApiResponse("Darshan Details with Id"+darshan.getId()+"cancelled....");
		}
		else
		
		return new ApiResponse("Darshan can't be cancel as the buffer limit of 15 days has crossed....");
	}

	@Override
	public List<String> getAllBookedTimeSlotsByDate(LocalDate bookingDate) {
		List<TimeSlot> timeslots =darshanDao.findAllTimeSlotsByDate(bookingDate);

		return timeslots.stream().map(t->t.toString()).collect(Collectors.toList());
	}

	@Override
	public List<LocalDate> getAllBookedDates() {

		return darshanDao.findAllBookingDatesByPersons();
	}

	/*
	 * //List of Darshan Bookings By Particular User
	 * 
	 * @Override public List<DarshanResponseDTO> getAllDarshanBookingsByUserId(Long
	 * userId) { List<Darshan> darshanlist =darshanDao.findUserById(userId); return
	 * darshanlist.stream().map(darshan ->
	 * mapper.map(darshan,DarshanResponseDTO.class)).collect(Collectors.toList()); }
	 */
	

}
