package com.app.dto;

import java.time.*;

//import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import com.app.entities.PoojaType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PoojaRequestDTO {
	
	@JsonProperty(access = Access.READ_ONLY) // this property only used during ser.
	private Long id;
	
	@NotNull
	private PoojaType pooja;
	
	@NotNull
	private LocalDate date;
	
	@NotNull
	@Range(max = 2)
	private int noOfPerson;
	
	@NotNull
	private double amount;
	

}
