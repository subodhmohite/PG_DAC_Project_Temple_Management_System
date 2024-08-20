package com.app.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.Pooja;
import com.app.entities.PoojaType;

public interface PoojaDao extends JpaRepository<Pooja, Long> {
	
	List<Pooja> findByUserId(Long userId);

	List<Pooja> findByDateAndPooja(LocalDate date,PoojaType pooja);

	@Query("SELECT p FROM Pooja p WHERE p.date = :date GROUP BY p.pooja HAVING SUM(p.noOfPerson) >= 4")
	List<PoojaType> findPoojaTypeByDate(LocalDate date);
	
	@Query("SELECT p FROM Pooja p GROUP BY p.date HAVING SUM(p.noOfPerson) >= 8 ")
	List<LocalDate> findAllBookedDatesByNoOfPerson();
 }
