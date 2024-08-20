package com.app.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.app.entities.Gender;
import com.app.entities.State;
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

	@JsonProperty(access = Access.READ_ONLY) // this property only used during ser.
	private Long id;
	
	@NotBlank(message = "First Name required")
	private String firstName;
	
	private String lastName;
	
	@Email(message = "Invalid Email!!!")
	private String email;
	
	@NotBlank(message = "Please enter your mobile number in order to proceed!")
	@Pattern(regexp="^\\d{10}$",message = "Invalid number :(")
	private String mobileNo;
	
	private UserRole role;
	
	private LocalDate dob;

	private Gender gender;

	@NotNull(message="This field cannot contain null value")
	@NotBlank(message="This field cannot be empty!")
	private String adharNumber;
	
	
	
	
	
	
	
		
	
	
	
	
}
