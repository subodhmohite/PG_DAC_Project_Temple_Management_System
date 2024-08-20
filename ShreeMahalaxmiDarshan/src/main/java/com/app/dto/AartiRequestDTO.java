package com.app.dto;

import java.time.LocalDate;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;
import com.app.entities.AartiType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor

public class AartiRequestDTO 
{
	@JsonProperty(access = Access.READ_ONLY) // this property only used during ser.
	private Long id;
	
	@NotNull
	private LocalDate aartiBookingDate;
	
	@NotNull
	private AartiType aartiBookingType;
	
	@NotNull
	@Range(max = 4)
	private int noOfPerson;
	
	@NotNull
	private double amount;
}
