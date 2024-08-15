
  package com.app.service;
  
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.customexception.ResourceNotFoundException;
import com.app.dto.ApiResponse;
import com.app.dto.PoojaRequestDTO;
import com.app.dto.PoojaResponseDTO;
import com.app.entities.Pooja;
import com.app.entities.PoojaType;
import com.app.entities.UserEntity;
import com.app.repository.PoojaDao;
import com.app.repository.UserDao;
  
  
 @Service
 @Transactional
 public class PoojaServiceImpl implements PoojaService {
	 @Autowired private UserDao userDao;
	  
	 @Autowired private PoojaDao poojaDao;
	  
	 @Autowired private ModelMapper mapper;
	  
	 @Override public ApiResponse addPoojaBooking(PoojaRequestDTO pooja, Long userId){ 
		 UserEntity curUser= userDao.findById(userId).
				  orElseThrow(()->new ResourceNotFoundException("User not Found,Invalid User ID"+userId));
		  
		 Pooja poojaEntity = mapper.map(pooja,Pooja.class);
		  
		 List<Pooja> poojaList = poojaDao.findByPoojaDateAndPoojaType(poojaEntity.getPoojaDate(), poojaEntity.getPoojaType());
		  
		 int noofPoojaBookingsByDate = poojaList.stream().mapToInt(Pooja::getNoOfPerson).sum();
		  
		if(noofPoojaBookingsByDate +poojaEntity.getNoOfPerson()> 4)
			 return new ApiResponse("Booking not Available for the specified pooja type on this Date,Try Another Dates!!");
		 
		 poojaEntity.setUser(curUser); 
		 poojaEntity.setAadhaarno(curUser.getAadhaarno());
		 poojaEntity.setDevoteename(curUser.getFirstname()+" "+curUser.getLastname());
		 Pooja persitentpooja = poojaDao.save(poojaEntity);
		 System.out.println(persitentpooja);
		  
		 return new ApiResponse("Pooja Booking Succesfully Booked!!!!"); 
		 }

	@Override
	public List<PoojaResponseDTO> getAllPoojaBookings() {
		Sort sortByDate = Sort.by(Sort.Direction.ASC,"poojaDate");//Sort by the 'date' property in ascending order
		List<Pooja> list =poojaDao.findAll(sortByDate);
		return list.stream().map(pooja-> mapper.map(pooja,PoojaResponseDTO.class)).collect(Collectors.toList());
	}

	@Override
	public ApiResponse deletePoojaBookingById(Long poojaId) {
		Pooja cancelPooja= poojaDao.findById(poojaId).
				orElseThrow(() -> new ResourceNotFoundException("Pooja  can't be deleted : Invalid Pooja Id!!!"));
		
		LocalDate currentDate = LocalDate.now();
		
		long differenceInDays = java.time.temporal.ChronoUnit.DAYS.between(currentDate, cancelPooja.getPoojaDate());

		if(differenceInDays >= 7)
		{
			poojaDao.delete(cancelPooja);
			return new ApiResponse("Pooja Details of dasrhan with ID " + cancelPooja.getId() + " cancelled....");
		}
		
		else 
			return new ApiResponse("Pooja can't be cancelled as the buffer limit of 15 days has crossed....");
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
  
 