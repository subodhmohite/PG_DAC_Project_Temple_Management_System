package com.app.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.app.entities.Gender;
import com.app.entities.UserRole;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserDTO {
	
	@JsonProperty(access = Access.READ_ONLY) //This property only used during serialization 
	private Long id;
	
	@NotNull(message = "This field cannot contain null values")
	@NotBlank(message = "This field cannot be empty")
	private String aadhaarno;
	
	@NotBlank(message = "First name required")
	private String firstname;
	
	private String lastname;
	
	@Email(message = "Invalid email")
	private String email;
	
	@NotBlank(message = "Please enter valid mobile number in order to proceed!")
	@Pattern(regexp = "^\\d{10}$",message = "Invalid number")
	private String mobileno;
	
	private UserRole role;
	
	private LocalDate dob;
	
	private Gender gender;
	
	
	
	
	

}
