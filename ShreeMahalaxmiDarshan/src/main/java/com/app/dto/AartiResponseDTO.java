package com.app.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.app.entities.AartiType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AartiResponseDTO {
	
	private Long id;
	
	@NotNull
	private LocalDate aartiDate;
	
	@NotNull
	private AartiType aartiType;
	
	@NotNull
	private int noOfPerson;
	
	@NotNull
	private double amount;
	
	@NotBlank
	@NotNull
	private String devoteename;
	
	@NotBlank
	@NotNull
	private String aadhaarno;

}
