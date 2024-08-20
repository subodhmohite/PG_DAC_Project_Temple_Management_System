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
public class Darshan extends BaseEntity{


	@Column(name="booking_date")
	private LocalDate bookingDate;
	
	@Column(name = "timeslot")
	@Enumerated(EnumType.STRING)
	private TimeEnum timeSlot;
	
	@Column(name="no_of_persons")
	private int persons;
	
	
	private double amount;
	
	@Column(name="primary_devotee_name")
	private String primaryDevoteeName;
	

	@Column(name= "adhar_no")
	private String adharNo;

	@ManyToOne
	@JoinColumn(name = "user_id") // Optional BUT reco , to specify the name of FK col.
	private UserEntity user;
	
	
	
	
//	@Column(name="no_of_women")
//	private int women;
//	
//	@Column(name="no_of_children")
//	private int children;
//	public Integer counter;
	
	
	public Darshan(LocalDate bookingDate, TimeEnum timeSlot, int persons, float amount, String primaryDevoteeName,
			String adharNo) {
		super();
		this.bookingDate = bookingDate;
		this.timeSlot = timeSlot;
		this.persons = persons;
		this.amount = amount;
		this.primaryDevoteeName = primaryDevoteeName;
		this.adharNo = adharNo;
	}




	@Override
	public String toString() {
		return "Darshan [bookingDate=" + bookingDate + ", timeSlot=" + timeSlot + ", persons=" + persons + ", amount="
				+ amount + ", primaryDevoteeName=" + primaryDevoteeName + ", adharNo=" + adharNo + ", user=" + user
				+ "]";
	}

	
	
	
}
