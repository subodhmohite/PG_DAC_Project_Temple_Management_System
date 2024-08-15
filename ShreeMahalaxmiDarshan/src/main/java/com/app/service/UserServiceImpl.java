package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.customexception.ResourceNotFoundException;
import com.app.dto.ApiResponse;
import com.app.dto.SigninDTO;
import com.app.dto.SignupDTO;
import com.app.dto.UserDTO;
import com.app.entities.UserEntity;
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
		UserEntity user=mapper.map(regdto, UserEntity.class);
		user.setPassword(user.getPassword());
		user.setRole(UserRole.DEVOTEE);
		

		return mapper.map(userDao.save(user),SignupDTO.class );
	}
	
	
	//User Sign in
	@Override
	public UserDTO findUserByEmailAndPassword(SigninDTO dto) {
		UserEntity curUser = userDao.findByEmailAndPassword(dto.getEmail(),dto.getPassword()).
				orElseThrow(()-> 
		new ResourceNotFoundException("Invalid Email and Password Try again!!!"));
		
		return mapper.map(curUser, UserDTO.class);	

	}
	
	//Get User Profile
	@Override
	public UserDTO getUserProfile(Long userid) {
		UserEntity curUser = userDao.findById(userid).
				orElseThrow(()->
				new ResourceNotFoundException("Invalid User Id,User not Found!!!"));

		return mapper.map(curUser,UserDTO.class);
	}


	//Get All Users only for ADMIN
	@Override
	public List<UserDTO> getAllUsers() {
		List<UserEntity> allUsers= userDao.findAll();
		return allUsers.stream().map(User ->mapper.map(User,UserDTO.class)).collect(Collectors.toList());

		
	}


	//Delete User By Id only for ADMIN
	@Override
	public ApiResponse deleteByUserId(Long userid) {
		if(userDao.existsById(userid)) {
			userDao.deleteById(userid);
			return new ApiResponse("User with id "+userid+" deleted");
		}

		return new ApiResponse("Invalid Id!!!!") ;
	}


	/*@Override
	public ApiResponse changePassword(SigninDTO dto,UserChangePasswordDTO passdto) {
		UserEntity curUser = userDao.findByEmailAndPassword(dto.getEmail(),dto.getPassword()).
				orElseThrow(()-> new ResourceNotFoundException("User Not Found,Invalid Email or Password"));
		
		if(dto.getPassword().equals(passdto.getPassword())) {
			curUser.setPassword(passdto.getConfirmNewPassword());
		}
		else
		{
			throw new ApiException("Password does not match");
		}
		return new ApiResponse("Password Changed");
*/
		
	
	
	
	

	/*
	 * //Update User Profile
	 * 
	 * @Override public UserDTO updateUserById(Long id, @Valid UserDTO updatedto) {
	 * User curUser = userDao.findById(id). orElseThrow(()-> new
	 * ResourceNotFoundException("Invalid Id, User not Found!!!!"));
	 * mapper.map(updatedto,curUser);
	 * 
	 * return mapper.map(userDao.save(curUser), UserDTO.class); }
	 */
	
	


	
	
	
	
	

	
	
	
	
	

}
