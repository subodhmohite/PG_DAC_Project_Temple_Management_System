package com.app.dto;

import java.time.*;

import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import com.app.entities.PoojaType;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PoojaResponseDTO {
	
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
	
	@NotBlank
	@NotNull
	private String primaryDevoteeName;
	
	@NotBlank
	@NotNull
	private String adharNo;
	
	
}
