package com.app.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import com.app.entities.PoojaType;
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
public class PoojaRequestDTO {
	
	@JsonProperty(access = Access.READ_ONLY)
	private Long id;
	
	@NotNull
	private PoojaType poojaType;
	
	@NotNull
	private LocalDate poojaDate;
	
	@NotNull
	@Range(max = 2)
	private int noOfPerson;
	
	@NotNull
	private double amount;


}
