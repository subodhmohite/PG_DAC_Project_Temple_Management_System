package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="address")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Address extends BaseEntity {

	//one-to-one , uni dir Address 1--->1 Employee
	//owning side : Address (since FK)
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id",nullable=false)
	@MapsId //shared primary approach
	private UserEntity user;
	
	@Column(name="add_line_one",length = 120)
	private String lineOne;
	
	@Column(name="add_line_two",length=120)
	private String lineTwo;
	
//	@Getter
//	@Setter(value = AccessLevel.NONE)
	
	@Column(name="country", nullable = false, columnDefinition = "VARCHAR(20) DEFAULT 'BHARAT(India)'")
	private String country = "BHARAT(India)";
	
	@Column(name="pincode",length=7)
	private String pincode;
	
	@Enumerated(EnumType.STRING)
	private State state;
	
	@Column(name="district",length=20)
	private String district;
	

	
	
	
	
	
	
	
}
