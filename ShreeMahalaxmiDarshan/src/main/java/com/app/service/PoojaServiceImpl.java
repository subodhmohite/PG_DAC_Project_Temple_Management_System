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
import com.app.dao.PoojaDao;
import com.app.dao.UserEntityDao;
import com.app.dto.ApiResponse;
import com.app.dto.PoojaRequestDTO;
import com.app.dto.PoojaResponseDTO;
import com.app.entities.Pooja;
import com.app.entities.PoojaType;
import com.app.entities.UserEntity;


@Service
@Transactional
public class PoojaServiceImpl implements PoojaService{
	
	@Autowired
	private UserEntityDao userDao;
	
	@Autowired
	private PoojaDao poojaDao;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public ApiResponse addPoojaBooking(PoojaRequestDTO pooja,Long userId) {
		UserEntity curUser= userDao.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Inavalid userId"));
		Pooja poojaEntity=  mapper.map(pooja, Pooja.class);
		
		List<Pooja> poojaList= poojaDao.findByDateAndPooja(poojaEntity.getDate(),poojaEntity.getPooja());
		
		int noOfPoojaBookingsByDate = poojaList.stream()
				.mapToInt(Pooja::getNoOfPerson)
				.sum();
		
		if(noOfPoojaBookingsByDate +poojaEntity.getNoOfPerson() > 4)
			return new ApiResponse("Booking not available for the specified pooja type on this date :( ");
		
		
		poojaEntity.setUser(curUser);
		poojaEntity.setPrimaryDevoteeName(curUser.getFirstName()+" "+curUser.getLastName());
		poojaEntity.setAdharNo(curUser.getAdharNumber());
		Pooja persistentpooja = poojaDao.save(poojaEntity);
		System.out.println(persistentpooja);
		return new ApiResponse("Pooja Booking done successfully!!!");
	}

	@Override
	public List<PoojaResponseDTO> getAllPoojaBookingsByUserId(Long userId) {
		List<Pooja> poojaList = poojaDao.findByUserId(userId);
		return poojaList.stream().map(pooja -> mapper.map(pooja, PoojaResponseDTO.class)).collect(Collectors.toList());
	}

	@Override
	public ApiResponse deletePoojaBookingById(Long poojaId) {
		
		Pooja cancelPooja= poojaDao.findById(poojaId).orElseThrow(() -> new ResourceNotFoundException("Pooja  can't be deleted : Invalid Pooja Id!!!"));
		
		LocalDate currentDate = LocalDate.now();
		
		long differenceInDays = java.time.temporal.ChronoUnit.DAYS.between(currentDate, cancelPooja.getDate());

		if(differenceInDays >= 15)
		{
			poojaDao.delete(cancelPooja);
			return new ApiResponse("Pooja Details of dasrhan with ID " + cancelPooja.getId() + " cancelled....");
		}
		
		else 
			return new ApiResponse("Pooja can't be cancelled as the buffer limit of 15 days has crossed....");
			
	}

	@Override
	public List<PoojaResponseDTO> getAllPoojaBookings() {
		Sort sortByDate = Sort.by(Sort.Direction.ASC, "date"); // Sort by the 'date' property in ascending order
		List<Pooja> list= poojaDao.findAll(sortByDate);
		return list.stream().map(pooja -> mapper.map(pooja, PoojaResponseDTO.class)).collect(Collectors.toList());
	}
	
	

	@Override
	public List<LocalDate> getAllBookedDates() {
		return poojaDao.findAllBookedDatesByNoOfPerson();
	}

	
	@Override
	public List<String> getBookedPoojaTypeForTheDate(LocalDate date) {
		List<PoojaType> typeList=poojaDao.findPoojaTypeByDate(date);
		
		return typeList.stream().map(t->t.toString()).collect(Collectors.toList()); 
	}

	
	
	

	


}
