package com.app.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class DonationResponseDTO {
	
	private Long id;
	
	@NotNull
	@CreationTimestamp
	private LocalDate ddate;
	
	@NotNull
	@NotBlank
	private String purpose;
	
	@NotNull
	private double amount;
	
	@NotNull
	private String aadhaarno;
	
	@NotNull
	private String dname;
	
	@NotNull
	private String dlastname;
	
}

