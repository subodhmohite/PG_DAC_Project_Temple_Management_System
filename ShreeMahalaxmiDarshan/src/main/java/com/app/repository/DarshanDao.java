package com.app.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Darshan;
import com.app.entities.TimeSlot;

public interface DarshanDao extends JpaRepository<Darshan, Long> {
	
	List<Darshan> findUserById(Long userId);
	
	List<Darshan> findUserByBookingDateAndTimeSlot(LocalDate bookingdate,TimeSlot timeslot);
	
	

}
