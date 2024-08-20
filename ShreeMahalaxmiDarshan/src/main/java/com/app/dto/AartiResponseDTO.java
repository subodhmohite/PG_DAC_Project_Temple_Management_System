package com.app.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;
import com.app.entities.AartiType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class AartiResponseDTO 
{
	private Long id;
	
	@NotNull
	private LocalDate aartiBookingDate;
	
	@NotNull
	private AartiType aartiBookingType;
	
	@NotNull
	private int noOfPerson;
	
	@NotNull
	private double amount;
	
	@NotBlank
	@NotNull
	private String primaryDevoteeName;
	
	@NotBlank
	@NotNull
	private String adharNo;
}
