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
import com.app.dao.AartiDao;
import com.app.dao.UserEntityDao;
import com.app.dto.AartiRequestDTO;
import com.app.dto.AartiResponseDTO;
import com.app.dto.ApiResponse;
import com.app.entities.Aarti;
import com.app.entities.UserEntity;


@Service
@Transactional
public class AartiServiceImpl implements AartiService 
{
	@Autowired
	private AartiDao aartiDao;
	
	@Autowired
	private UserEntityDao userDao;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public ApiResponse addAartiBooking(AartiRequestDTO aarti,Long userId) {
		UserEntity curUser= userDao.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Invalid userId"));
		Aarti aartiEntity = mapper.map(aarti, Aarti.class);
		
		
		List<Aarti> list = aartiDao.findByAartiBookingDateAndAartiBookingType(aarti.getAartiBookingDate(),aarti.getAartiBookingType());
		
		int noOfPersonsByDateAndType = list.stream()
									   .mapToInt(Aarti::getNoOfPerson)
									   .sum();
		
		if(noOfPersonsByDateAndType + aarti.getNoOfPerson() > 5)
			return new ApiResponse("No Booking Available For the TimeSlot on The Date You Asking ---");
		
		aartiEntity.setUser(curUser);
		aartiEntity.setPrimaryDevoteeName(curUser.getFirstName()+" "+curUser.getLastName());
		aartiEntity.setAdharNo(curUser.getAdharNumber());
		
		Aarti persistentEnt = aartiDao.save(aartiEntity);
			
		return new ApiResponse("Aarti Booking Successfully done for given Time");
	}

	@Override
	public List<AartiResponseDTO> getAllAartiBookingsByUserId(Long userId) {
		
		List<Aarti> aartiList = aartiDao.findByUserId(userId);
		return aartiList.stream().map(aarti -> mapper.map(aarti, AartiResponseDTO.class)).collect(Collectors.toList());
	}

	@Override
	public ApiResponse deleteAartiBookingById(Long id) {	

		Aarti aarti = aartiDao.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("Invalid emp id"));
		
		LocalDate currentDate = LocalDate.now();
		
		long differenceInDays = java.time.temporal.ChronoUnit.DAYS.between(currentDate, aarti.getAartiBookingDate());
		
		if(differenceInDays >= 15)
		{
			aartiDao.delete(aarti);
			return new ApiResponse("Aarti Details of aarti with ID " + aarti.getId() + " cancelled....");
			
		}
		
//		aartiDao.delete(aarti);
		else
			return new ApiResponse("Aarti can't be cancelled as the buffer limit of 15 days has crossed....");

	}
	
	@Override
	public List<AartiResponseDTO> getAllAartiBookings() {
		
//		List<Aarti> aartiSortedList = aartiDao.findAllOrderedByADateAsc();
		Sort sortByDate = Sort.by(Sort.Direction.ASC, "aartiBookingDate");
		List<Aarti> aartiSortedList = aartiDao.findAll(sortByDate);
		return aartiSortedList.stream()
				.map(aarti -> mapper.map(aarti, AartiResponseDTO.class))
				.collect(Collectors.toList());

	}
	
}




/*@Override
public List<String> getAllBookedTimeSlotsByDate(LocalDate bookingDate) {
	 List<TimeEnum> timeslots = darshanDao.findAllTimeSlotsByBookingDate(bookingDate);
	// timeslots.forEach(t -> t.toString());
	 return  timeslots.stream().map(t->t.toString()).collect(Collectors.toList());
	 
}

@Override
public List<LocalDate> getAllBookedDates() {
	return darshanDao.findAllBookingDatesByPersons();
}*/

//List<Aarti> sortedAartiList = aartiDao.findAllByOrderByADateAsc();
//return sortedAartiList.stream()
//        .map(aarti -> mapper.map(aarti, AartiDTO.class))
//        .collect(Collectors.toList());






