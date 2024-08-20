package com.app.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.mail.MessagingException;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_Exceptions.ResourceNotFoundException;
import com.app.dao.AddressDao;
import com.app.dao.UserEntityDao;
import com.app.dto.ApiResponse;
import com.app.dto.OtpDTO;
import com.app.dto.ResetPassword;
import com.app.dto.Signup;
import com.app.dto.UserChangePasswordDTO;
import com.app.dto.UserDTO;
import com.app.entities.Address;
import com.app.entities.UserEntity;
import com.app.entities.UserRole;
import com.app.utils.EmailUtil;
import com.app.utils.OtpUtil;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserEntityDao userDao;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private AddressDao addDao;
	
	@Autowired
	private EmailUtil emailUtil;
	
	@Autowired
	private OtpUtil optUtil;

	//SIGNUP
	@Override
	public Signup userRegistration(Signup reqDTO) {
		
		UserEntity user=mapper.map(reqDTO, UserEntity.class);
		user.setPassword(encoder.encode(user.getPassword()));//pwd : encrypted using SHA
		user.setRole(UserRole.ROLE_USER);
		return mapper.map(userDao.save(user), Signup.class);
	}

	
	//GET PROFILE
	@Override
	public UserDTO getUserProfile(Long userId) {
		UserEntity curUser= userDao.findById(userId).orElseThrow(()-> new ResourceNotFoundException("Invalid user ID, User not found!!"));
		
		return mapper.map(curUser, UserDTO.class) ;
	}
			
		
		
		
		
	//UPDATE PROFILE
	@Override
	public UserDTO updateUser(Long userId, @Valid UserDTO dto) {
		
		UserEntity curUser= userDao.findById(userId).orElseThrow(()-> new ResourceNotFoundException("Invalid user ID, User not found!!"));
		mapper.map(dto, curUser);
		return mapper.map(userDao.save(curUser), UserDTO.class);
	}

	

	//CHANGE PASSWORD
	
	@Override
	public ApiResponse changeUserPassword(Long userId, UserChangePasswordDTO dto) {
		
		if(dto.getNewPassword().equals(dto.getConfirmNewPassword()))
		{
			UserEntity curUser=userDao.findById(userId).orElseThrow(()-> new ResourceNotFoundException("Invalid user ID, User not found!!"));
			String encryptedPassword = encoder.encode(dto.getConfirmNewPassword());
			curUser.setPassword(encryptedPassword);
		}
		else
		{
			throw new ResourceNotFoundException("Passwords don't match");
		}
		
		return new ApiResponse("Password changed successfully");
	}
	

	
	//GET ALL USERS ADMIN POV

	@Override
	public List<UserDTO> getAllUsers() {
		List<UserEntity> allUsers= userDao.findAll();
		return allUsers.stream().map(UserEntity -> mapper.map(UserEntity, UserDTO.class)).collect(Collectors.toList());
	}


	//DELETE USER ADMIN POV
		@Override
		public ApiResponse deleteUserDetails(Long userId) {
			
			Optional<Address> optAddr = addDao.findById(userId);
			if(optAddr.isPresent())
				addDao.delete(optAddr.get());
			
			UserEntity user= userDao.findById(userId).orElseThrow(()-> new ResourceNotFoundException("Invalid id , can't delete"));
			
			userDao.delete(user);
			
			
			return new ApiResponse("User with ID" +user.getId() +" deleted.");
		}

		
		//FORGOT PASSWORD USING EMAIL

		@Override
		public ApiResponse forgotPassword(String email) {
			
			String otp=optUtil.generateOtp();
			UserEntity user=userDao.findByEmail(email).orElseThrow(()->new UsernameNotFoundException(email));
			if(user!=null)
			{
				try {
					emailUtil.sendOtpEmail(email,otp);
					user.setOtp(otp);
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					throw new RuntimeException("Unable to send otp,please try again");
				}
			}
			return new ApiResponse("email sent successfully,check you email");

		}

		
		/**
		 * Otp will be verified and store in the DB
		 * */
		@Override
		public OtpDTO verifyOtp(OtpDTO userRequest) {
			String email=userRequest.getEmail();
			UserEntity user=userDao.findByEmail(email).orElseThrow(()->new UsernameNotFoundException(email));
			String otp=user.getOtp();
			if(user!=null)
			{
				if(userRequest.getOtp().equals(otp))
				{
					return new OtpDTO(email,otp);
				}
			}
			return new OtpDTO("invalid email","or otp");
		}
		
		/**
		 * We will fetch the OTP from the DB and the url and
		 * then the password will be updated
		 * */
		@Override
		public ApiResponse resetPassword( ResetPassword object) {
			UserEntity user=userDao.findByEmail(object.getEmail()).orElseThrow(()->new UsernameNotFoundException(object.getEmail()));
			String dbSavedOtp=user.getOtp();
			if(object.getOtp().equals(dbSavedOtp))
			{
				user.setPassword(encoder.encode(object.getPassword()));
				return new ApiResponse("password updated successfully");
			}
			return new ApiResponse("password updation failed");
		}



	
	
	

	
	
}
