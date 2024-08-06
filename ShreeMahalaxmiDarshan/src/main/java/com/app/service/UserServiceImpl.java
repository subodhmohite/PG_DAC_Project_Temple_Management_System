package com.app.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.customexception.ResourceNotFoundException;
import com.app.dto.SigninDTO;
import com.app.dto.SignupDTO;
import com.app.dto.UserDTO;
import com.app.entities.User;
import com.app.entities.UserRole;
import com.app.repository.UserDao;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ModelMapper mapper;
	
	//User Registration as Devotee
	@Override
	public SignupDTO userRegistration(SignupDTO regdto) {
		User user=mapper.map(regdto, User.class);
		user.setPassword(user.getPassword());
		user.setRole(UserRole.devotee);
		

		return mapper.map(userDao.save(user),SignupDTO.class );
	}
	
	
	//User Sign in
	@Override
	public UserDTO findUserByEmailAndPassword(SigninDTO dto) {
		User curUser = userDao.findByEmailAndPassword(dto.getEmail(),dto.getPassword()).
				orElseThrow(()-> 
		new ResourceNotFoundException("Invalid Email and Password Try again!!!"));
		
		return mapper.map(curUser, UserDTO.class);	

	}
	
	

	
	
	
	
	

}
