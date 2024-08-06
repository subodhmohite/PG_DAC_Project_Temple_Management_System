package com.app.service;

import com.app.dto.*;



public interface UserService {
	
	UserDTO findUserByEmailAndPassword(SigninDTO dto);

}
