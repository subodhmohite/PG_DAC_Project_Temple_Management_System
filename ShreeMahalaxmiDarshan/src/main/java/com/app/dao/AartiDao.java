package com.app.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.Aarti;
import com.app.entities.AartiType;

public interface AartiDao extends JpaRepository<Aarti, Long> 
{
	List<Aarti> findByUserId(Long userId);


//	@Query("SELECT a FROM Aarti a ORDER BY a.aartiBookingDate ASC")
//	List<Aarti> findAllOrderedByADateAsc();
	
	List<Aarti> findByAartiBookingDateAndAartiBookingType(LocalDate date, AartiType aartiType);
	
}
