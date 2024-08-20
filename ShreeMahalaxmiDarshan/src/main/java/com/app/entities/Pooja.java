package com.app.entities;

import java.time.*;
import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "Pooja")
@NoArgsConstructor
@AllArgsConstructor

public class Pooja extends BaseEntity{
	
	
	
	@Column(name = "pooja_date")
	private LocalDate date;
	
	@Column(name = "no_of_person")
	private int noOfPerson;
	
	
	private double amount;
	
	@Enumerated(EnumType.STRING)
	@Column(name="pooja_type")
	private PoojaType pooja;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity user;
	

	@Column(name = "primary_devotee_name")
	private String primaryDevoteeName;
	
	@Column(name = "adhar_no",length = 12)
	private String adharNo;

	public Pooja(LocalDate date, int noOfPerson, double amount, PoojaType pooja, String primaryDevoteeName,
			String adharNo) {
		super();
		this.date = date;
		this.noOfPerson = noOfPerson;
		this.amount = amount;
		this.pooja = pooja;
		this.primaryDevoteeName = primaryDevoteeName;
		this.adharNo = adharNo;
	}

	@Override
	public String toString() {
		return "Pooja [date=" + date + ", noOfPerson=" + noOfPerson + ", amount=" + amount + ", pooja=" + pooja
				+ ", user=" + user + ", primaryDevoteeName=" + primaryDevoteeName + ", adharNo=" + adharNo + "]";
	}

	
}
