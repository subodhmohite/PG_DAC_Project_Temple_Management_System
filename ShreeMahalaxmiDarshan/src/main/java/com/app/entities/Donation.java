
package com.app.entities;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="donation")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Donation extends BaseEntity {
	
	@Column(name="aadhaar_no",length=12,nullable=false)
	@Size(min=12,max=12)
	private String aadhaarno;
	
	@Column(name="devotee_name",length=30,nullable=false)
	private String dname;
	
	@Column(name="devotee_lastname",length=30,nullable=false)
	private String dlastname;
	
	private double amount;
	
	@Column(name="donation_date",nullable=false)
	@CreationTimestamp
	private LocalDate ddate;
	
	@Column(name="purpose",length=100)
	private String purpose;
	
	@ManyToOne
	@JoinColumn(name="user_id",nullable=false)
	private UserEntity user;
	
	

}
