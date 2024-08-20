package com.app.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class AccommodationResponseDTO 
{
	private Long id;
	
	@NotNull
	@Range(max=2)
	private int numberOfDays;
	
	@NotNull
	private LocalDate checkInDate;
	
	@NotNull
	private LocalTime checkInTime;
	
	@NotNull
	@Range(max=2)
	private int numberOfRooms;
	
	@NotNull
	private double amount;
	
	@NotBlank
	@NotNull
	private String primaryDevoteeName;
	
	@NotBlank
	@NotNull
	private String adharNo;
	
}
