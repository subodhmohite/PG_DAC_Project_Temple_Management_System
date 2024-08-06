package com.app.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.customexception.ResourceNotFoundException;
import com.app.dto.SigninDTO;
import com.app.dto.UserDTO;
import com.app.entities.User;
import com.app.repository.UserDao;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public UserDTO findUserByEmailAndPassword(SigninDTO dto) {
		User curUser = userDao.findByEmailAndPassword(dto.getEmail(),dto.getPassword()).
				orElseThrow(()-> 
		new ResourceNotFoundException("Invalid Email and Password Try again!!!"));
		
		return mapper.map(curUser, UserDTO.class);	

	}
	
	
	
	
	

}
