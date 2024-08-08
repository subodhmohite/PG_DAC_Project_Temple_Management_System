package com.app.dto;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserChangePasswordDTO {

	@JsonProperty(access = Access.WRITE_ONLY)
	@Size(min=8,max=8,message = "Password must contain 8 Characters")
	private String password;
	
	@Size(min = 8,max = 8,message = "Password must contain 8 Characters")
	private String newPassword;
	
	private String confirmNewPassword;

}
