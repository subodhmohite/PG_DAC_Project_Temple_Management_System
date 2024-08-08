package com.app.entities;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="donation")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Donation extends BaseEntity {
	
	@Column(name="addhar_no",length=12,nullable=false)
	@Size(min=12,max=12)
	private String addharno;
	
	@Column(name="devotee_name",length=30,nullable=false)
	private String dname;
	
	@Column(name="devotee_lastname",length=30,nullable=false)
	private String dlastname;
	
	private double amount;
	
	@Column(name="donation_date",nullable=false)
	private LocalDate ddate;
	
	@Column(name="purpose",length=100)
	private String purpose;
	
	@ManyToOne
	@JoinColumn(name="user_id",nullable=false)
	private UserEntity userid;
	
	

}
