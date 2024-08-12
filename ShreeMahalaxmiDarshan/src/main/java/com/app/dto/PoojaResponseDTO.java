package com.app.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import com.app.entities.PoojaType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PoojaResponseDTO {
	
	private Long id;
	
	@NotNull
	@NotBlank
	private String aadhaarno;
	
	@NotBlank
	@NotBlank
	private String devoteename;
	
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
