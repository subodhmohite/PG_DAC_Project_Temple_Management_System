package com.app.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class UserEntity extends BaseEntity {
	
	@Column(name="aadhaar_no",unique=true,length=12,nullable=false)
	@Size(min=12,max=12)
	private String aadhaarno;
	
	@Column(name="first_name",length=30,nullable=false)
	private String firstname;
	
	@Column(name="last_name",length=30,nullable=false)
	private String lastname;
	
	@Column(name="mobile_no",unique=true,nullable=false)
	@Size(min=10,max=10)
	private String mobileno;
	
	@Column(name="date_of_birth",nullable=false)
	private LocalDate dob;
	
	@Enumerated(EnumType.STRING)
	@Column(name="gender",length=20,nullable=false)
	private Gender gender;
	
	@Column(name="email",nullable=false,unique=true)
	private String email;
	
	@Column(length=8,nullable=false)
	@Size(min=8,max=8)
	private String password;
	
	@Column(length=50,nullable=false)
	private String address;
	
	@Enumerated(EnumType.STRING)
	@Column(length=7,nullable=false)
	private UserRole role;
	
	@OneToMany(mappedBy="user",cascade = CascadeType.ALL)
	private List<Darshan> darshanList = new ArrayList<Darshan>();
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private List<Aarti> aartiList = new ArrayList<Aarti>();
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private List<Pooja> poojaList =  new ArrayList<Pooja>();
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private List<Donation> donationList= new ArrayList<Donation>();
	
	
	
	
	
	
	
	
	

}
