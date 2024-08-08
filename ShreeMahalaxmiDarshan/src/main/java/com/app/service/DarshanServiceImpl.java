package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.customexception.ResourceNotFoundException;
import com.app.dto.ApiResponse;
import com.app.dto.DarshanRequestDTO;
import com.app.entities.Darshan;
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

}
