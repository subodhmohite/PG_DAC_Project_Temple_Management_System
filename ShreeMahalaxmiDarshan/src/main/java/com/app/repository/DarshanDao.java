package com.app.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.Darshan;
import com.app.entities.TimeSlot;

public interface DarshanDao extends JpaRepository<Darshan, Long> {
	
	List<Darshan> findUserById(Long userId);
	
	//For Darshan add
	List<Darshan> findUserByBookingDateAndTimeSlot(LocalDate bookingdate,TimeSlot timeslot);
	
	//Time Slots By Date For Admin
	@Query("select d.timeSlot from Darshan d where d.bookingDate = :bookingdate group by d.timeSlot having sum(d.noofperson)>=13")
	List<TimeSlot> findAllTimeSlotsByDate(LocalDate bookingdate);
	
	//All Booked Dates By No of persons
	@Query("select d.bookingDate from Darshan d group by d.bookingDate having sum(d.noofperson)>=100")
	List<LocalDate> findAllBookingDatesByPersons();
	

}
