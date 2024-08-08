package com.app.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import com.app.entities.TimeSlot;

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
public class DarshanResponseDTO {
	
	private Long id;
	
	@NotNull
	private String addharNo;
	
	@NotNull
	private String devoteename;
	
	@NotNull
	private LocalDate bookingdate;
	
	@NotNull
	private TimeSlot timeslot;
	
	@NotNull
	@Range(max = 4)
	private int persons;
	
	@NotNull
	private double amount;
	

}
