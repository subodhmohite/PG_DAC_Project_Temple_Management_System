package com.app.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OtpDTO {

	@Email
	private String email;
	
	@Pattern(regexp = "\\d{6}")
	private String otp;
}
