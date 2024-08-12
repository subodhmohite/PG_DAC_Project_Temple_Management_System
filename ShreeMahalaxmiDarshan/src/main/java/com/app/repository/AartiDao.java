package com.app.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Aarti;
import com.app.entities.AartiType;

public interface AartiDao extends JpaRepository<Aarti, Long> {
	
	List<Aarti> findByUserId(Long userId);
	
	List<Aarti> findByAartiDateAndAartiType(LocalDate aartiDate,AartiType AartiType);

}
