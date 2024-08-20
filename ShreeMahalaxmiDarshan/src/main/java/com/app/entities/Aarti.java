package com.app.entities;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "aarti")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Aarti extends BaseEntity
{
	
	
	@Column(name = "arti_date")
	private LocalDate aartiBookingDate;
	
	
	@Enumerated(EnumType.STRING)
	@Column(name = "aarti_type")
	private AartiType aartiBookingType;
	
	@Column(name = "no_of_person")
	private int noOfPerson;
	
	private double amount;
	
	@Column(name = "primary_devotee_name")
	private String primaryDevoteeName;
	
	@Column(name = "adhar_no",length = 12)
	private String adharNo;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity user;

	public Aarti(LocalDate aartiBookingDate, AartiType aartiBookingType, int noOfPerson, double amount,
			String primaryDevoteeName, String adharNo) {
		super();
		this.aartiBookingDate = aartiBookingDate;
		this.aartiBookingType = aartiBookingType;
		this.noOfPerson = noOfPerson;
		this.amount = amount;
		this.primaryDevoteeName = primaryDevoteeName;
		this.adharNo = adharNo;
//		this.user = user;
	}
	

	
	
	
	
}
