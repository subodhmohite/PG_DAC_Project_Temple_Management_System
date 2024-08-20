package com.app.controller;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.SigninRequest;
import com.app.dto.SigninResponse;
import com.app.dto.Signup;
import com.app.security.JwtUtils;
import com.app.service.UserService;

@RestController
@RequestMapping("/users")
public class UserSignInSignUpController {
	@Autowired
	private UserService userService;
	@Autowired
	private JwtUtils utils;

	@Autowired
	private AuthenticationManager mgr;

	// SIGN UP
	//method= GET 
	// https://localhost:8443/users/signup
	@PostMapping("/signup")
	public ResponseEntity<?> userSignup(@RequestBody @Valid Signup dto) {
		System.out.println("in sign up " + dto);
		if (dto.getConfirmPassword().equals(dto.getPassword()))
			{
				return ResponseEntity.status(HttpStatus.CREATED).body(userService.userRegistration(dto));
			}
		else
		{
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ApiResponse("Passwords do not match..:("));
	
		}
	}

	/*
	 * request payload : Auth req DTO : email n password resp payload : In case of
	 * success : Auth Resp DTO : mesg + JWT token + SC 200 IN case of failure : SC
	 * 401
	 */
	
	//SIGN IN
	//method= POST
	// https://localhost:8443/users/signin
	@PostMapping("/signin")
	public ResponseEntity<?> signinUser(@RequestBody @Valid SigninRequest reqDTO) {
		System.out.println("in signin " + reqDTO);
		// simply invoke authentucate(...) on AuthMgr
		// i/p : Authentication => un verifed credentials
		// i/f --> Authentication --> imple by UsernamePasswordAuthToken
		// throws exc OR rets : verified credentials (UserDetails i.pl class: custom
		// user details)
	try {
		Authentication verifiedAuth = mgr
				.authenticate(new UsernamePasswordAuthenticationToken
						(reqDTO.getEmail(), reqDTO.getPassword()));
		System.out.println(verifiedAuth.getClass());// Custom user details
//		// => auth success
//		return ResponseEntity
//				.ok(new SigninResponse(utils.generateJwtToken(verifiedAuth), "Successful Authentication!!!"));
		
		// Get the authorities (roles) assigned to the authenticated user
	    Collection<? extends GrantedAuthority> authorities = verifiedAuth.getAuthorities();

	    // Check if the user has the "ADMIN" role
	    boolean isAdmin = authorities.stream()
	                                  .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));

	    // Return response based on user's role
	    if (isAdmin) {
	        // If user is admin
	        return ResponseEntity.ok(new SigninResponse(utils.generateJwtToken(verifiedAuth), "ROLE_ADMIN"/*"Admin Authentication Successful!!!"*/));
	    } else {
	        // If user is not admin
	        return ResponseEntity.ok(new SigninResponse(utils.generateJwtToken(verifiedAuth), "ROLE_USER"/*"User Authentication Successful!!!"*/));
	    }
	}
	catch (AuthenticationException e) {
        // Authentication failed
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body("Authentication failed. Invalid email or password.");
    }

	}

}
