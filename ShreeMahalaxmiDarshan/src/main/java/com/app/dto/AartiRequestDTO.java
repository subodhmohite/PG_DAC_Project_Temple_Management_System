package com.app.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import com.app.entities.AartiType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AartiRequestDTO {
	
	@JsonProperty(access = Access.READ_ONLY) 
	private Long id;
	
	@NotNull
	private LocalDate aartiDate;
	
	@NotNull
	private AartiType aartiType;
	
	@NotNull
	@Range(max = 4)
	private int noOfPerson;
	
	@NotNull
	private double amount;

}
