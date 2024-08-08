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
import lombok.ToString;

@Entity
@Table(name="darshan")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString


public class Darshan extends BaseEntity  {
	
	
	
	@Column(name="addhar_no",length=12,nullable=false)
	@Size(min=12,max=12)
	private String addharno;
	
	@Column(name="devotee_name",length=30,nullable=false)
	private String devoteename;
	
	@Column(name="no_of_person")
	private int noofperson;
	
	@Enumerated(EnumType.STRING)
	@Column(name="timeslot",nullable=false)
	private TimeSlot timeSlot;
	
	@Column(name="booking_date",nullable=false)
	private LocalDate bookingDate;
	
	private double amount;
	
	@ManyToOne
	@JoinColumn(name="user_id",nullable=false) //recommended to specify the name of Foreign Key 
	private UserEntity userid;
}
