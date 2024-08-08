package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.UserEntity;

public interface UserDao extends JpaRepository<UserEntity, Long> {
	
	
	
	Optional<UserEntity> findByEmailAndPassword(String email,String password);

}
