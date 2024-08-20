package com.app.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "accommodation")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Accommodation extends BaseEntity {
	
	
	@Column(name = "no_of_days")
	private int numberOfDays;
	
	@Column(name = "check_in_date")
	private LocalDate checkInDate;
	
	@Column(name = "check_in_time")
	private LocalTime checkInTime;
	
	@Column(name = "no_of_rooms")
	private int numberOfRooms;
	
	@ManyToOne
	@JoinColumn(name = "user_id") // Optional BUT reco , to specify the name of FK col.
	private UserEntity user;
	
	@Column(name = "primary_devotee_name")
	private String primaryDevoteeName;
	
	@Column(name = "adhar_no",length = 12)
	private String adharNo;
	
	private double amount;
	
	public Accommodation(LocalDate checkInDate) {
		this.checkInDate = checkInDate;
	}

	public Accommodation(int numberOfDays, LocalDate checkInDate, LocalTime checkInTime, int numberOfRooms,
			String primaryDevoteeName, String adharNo, double amount) {
		super();
		this.numberOfDays = numberOfDays;
		this.checkInDate = checkInDate;
		this.checkInTime = checkInTime;
		this.numberOfRooms = numberOfRooms;
		this.primaryDevoteeName = primaryDevoteeName;
		this.adharNo = adharNo;
		this.amount = amount;
	}


	
}
