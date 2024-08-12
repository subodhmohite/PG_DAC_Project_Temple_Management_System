package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Donation;

public interface DonationDao extends JpaRepository<Donation, Long> {
	
	List<Donation> findUserById(Long userId);

}
