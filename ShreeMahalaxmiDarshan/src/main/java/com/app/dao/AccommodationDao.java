package com.app.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.Accommodation;

public interface AccommodationDao extends JpaRepository<Accommodation,Long>{
	List<Accommodation> findByUserId(Long userId);
	

	@Query("SELECT a FROM Accommodation a ORDER BY a.checkInDate ASC")
	List<Accommodation> findAllByOrderedByCheckInDateAsc();
	
	List<Accommodation> findByCheckInDate(LocalDate date);
	

	@Query("SELECT a.checkInDate FROM Accommodation a GROUP BY a.checkInDate HAVING SUM(a.numberOfRooms) >= 3")
	List<LocalDate> findAllCheckInDates();
	
	
	

	/*@Query("Select a.checkInDate from Accommodation a where a.roomCounter < 3")
	List<LocalDate> findCheckInDatesByRoomCounter();
	
	@Query("select distinct a.roomCounter from Accommodation a where a.checkInDate =:date")
	Integer findRoomCounterByCheckInDate(LocalDate date);*/

	
//	@Query("select a.checkInDate from Accommodation a group by a.checkInDate having sum(a.numberOfRooms)>=3 ")
//	List<LocalDate> findAllCheckInDates();
}
