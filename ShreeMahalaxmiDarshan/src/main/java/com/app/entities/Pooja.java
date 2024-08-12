package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="pooja")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Pooja extends BaseEntity {
	
	@Column(name="aadhaar_no",length=12,nullable=false)
	@Size(min=12,max=12)
	private String aadhaarno;
	
	@Column(name="devotee_name",length=30,nullable=false)
	private String devoteename;
	
	@Column(name="no_of_person")
	private int noOfPerson;
	
	@Column(name="pooja_date",nullable=false)
	private LocalDate poojaDate;
	
	@Enumerated(EnumType.STRING)
	@Column(name="pooja_type",length=20,nullable=false)
	private PoojaType poojaType;
	
	private double amount;
	
	@ManyToOne
	@JoinColumn(name="user_id",nullable=false)
	private UserEntity user;
	

}
