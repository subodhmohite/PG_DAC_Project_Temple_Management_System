package com.app.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import com.app.entities.TimeEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DarshanResponseDTO 
{	
	private Long id;
	
	@NotNull
	private LocalDate bookingDate;
	
	@NotNull
	private TimeEnum timeSlot;
	
	@NotNull
	@Range(max=4)
	private int persons;

	@NotNull
	private double amount;
	
	private String primaryDevoteeName;
	
	@NotNull
	private String adharNo;
	
	
}
