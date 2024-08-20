package com.app.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class AccommodationRequestDTO 
{
	@JsonProperty(access = Access.READ_ONLY) // this property only used during ser.
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
	
}
