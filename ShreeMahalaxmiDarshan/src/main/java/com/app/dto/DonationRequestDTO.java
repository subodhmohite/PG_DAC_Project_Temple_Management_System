package com.app.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

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
public class DonationRequestDTO {
	
	@JsonProperty(access = Access.READ_ONLY)
	private Long id;
	
	
	//@CreationTimestamp
	//@JsonProperty(access = Access.READ_ONLY)
	//private LocalDate ddate;
	
	@NotNull
	@NotBlank
	private String purpose;
	
	@NotNull
	private double amount;
	
	
}
