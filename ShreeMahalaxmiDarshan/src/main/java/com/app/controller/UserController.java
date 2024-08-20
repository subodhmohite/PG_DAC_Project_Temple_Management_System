package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.OtpDTO;
import com.app.dto.ResetPassword;
import com.app.dto.UserChangePasswordDTO;
import com.app.dto.UserDTO;
import com.app.security.FindUserDetails;
import com.app.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private FindUserDetails authUserDetails;
	
	//GET USER PROFILE
	//method=GET
	// http://localhost:8443/user/my-profile
	@GetMapping("/my-profile")
	public ResponseEntity<?> showUserProfile() {
		Long userId = authUserDetails.getUserId();
		System.out.println("in show profile " + userId);

		return ResponseEntity.ok(userService.getUserProfile(userId));
	}
	
	//UPDATE USER PROFILE
	  //method=PUT
	  // http://localhost:8443/user/my-profile/update-user
	//update the url according to front end
		@PutMapping("/my-profile/update-user")
		public ResponseEntity<?> updateUserDetails( @RequestBody @Valid UserDTO dto) {
		Long userId = authUserDetails.getUserId();
			System.out.println("in update user " + userId + " " + dto);
			return ResponseEntity.ok(userService.updateUser(userId, dto));
		}
		
	//CHANGE PASSWORD
	//method =patch
	// http://localhost:8443/user/change-password
	@PatchMapping("/change-password")
	public ResponseEntity<?> changePassword(@RequestBody @Valid UserChangePasswordDTO dto)
	{
		Long userId = authUserDetails.getUserId();
		System.out.println("in change password "+ userId + " ");
		return ResponseEntity.ok(userService.changeUserPassword(userId,dto));
	}
	
	
	//FORGOT PASSWORD
	//method=POST
	// http://localhost:8443/user/forgot-password
	@PostMapping("/forgot-password")
    public ResponseEntity<ApiResponse> forgotPassword(@RequestParam String email) {
        ApiResponse response = userService.forgotPassword(email);
        return ResponseEntity.ok(response);
    }

	
	//VERIFY OTP
	//method=POST
	// http://localhost:8443/user//verify-otp
    @PostMapping("/verify-otp")
    public ResponseEntity<OtpDTO> verifyOtp(@RequestBody OtpDTO userRequest) {
        OtpDTO response = userService.verifyOtp(userRequest);
        return ResponseEntity.ok(response);
    }
	
	
	//RESET PASSWORD
	//method=PUT
	// http://localhost:8443/user/reset-password
	@PutMapping("/reset-password")
	public	ResponseEntity<ApiResponse> resetPassword(@Valid @RequestBody ResetPassword object)
	{
		return new ResponseEntity<ApiResponse>(userService.resetPassword(object),HttpStatus.OK);
	}

}
