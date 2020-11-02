package com.luv2code.springsecurity.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "companyemail")
public class CompanyEmail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "mobileno")
	private Long mobileNumber;
	
	@Column(name = "username_id")
	private String username_id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getUsername_id() {
		return username_id;
	}

	public void setUsername_id(String username_id) {
		this.username_id = username_id;
	}

	@Override
	public String toString() {
		return "CompanyEmail [id=" + id + ", mobileNumber=" + mobileNumber + ", username_id=" + username_id + "]";
	}
	
	
}