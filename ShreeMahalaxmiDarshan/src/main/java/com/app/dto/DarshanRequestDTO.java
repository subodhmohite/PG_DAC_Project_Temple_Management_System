package com.app.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import com.app.entities.TimeSlot;
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
public class DarshanRequestDTO {
	
	@JsonProperty(access = Access.READ_ONLY)
	private Long id;
	
	@NotNull
	private LocalDate bookingDate;
	
	@NotNull
	private TimeSlot timeSlot;
	
	@NotNull
	@Range(max = 4)
	private int noofperson;
	
	@NotNull
	private double amount;
	
	
	

}
