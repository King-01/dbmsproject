package com.luv2code.springsecurity.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.luv2code.springsecurity.demo.validation.IsPercentage;

@Entity
@Table(name="tax")
public class Tax {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	@NotNull(message = "is required")
	@Size(min=1, message = "is required")
	@Column(name="taxtype")
	private String TaxName;
	
	@NotNull(message = "is required")
	@Size(min=1, message = "is required")
	@IsPercentage
	@Column(name="taxrate")
	private String taxPercent;
	
	@Column(name="username_id")
	private Long userid;

	@Override
	public String toString() {
		return "Tax [id=" + id + ", TaxName=" + TaxName + ", taxPercent=" + taxPercent + ", userid=" + userid + "]";
	}

	public String getTaxName() {
		return TaxName;
	}

	public void setTaxName(String taxName) {
		TaxName = taxName;
	}

	public String getTaxPercent() {
		return taxPercent;
	}

	public void setTaxPercent(String taxPercent) {
		this.taxPercent = taxPercent;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public Long getId() {
		return id;
	}
	
	
	
}
