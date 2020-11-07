package com.luv2code.springsecurity.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.luv2code.springsecurity.demo.validation.IsPan;
import com.luv2code.springsecurity.demo.validation.IsPincode;
import com.luv2code.springsecurity.demo.validation.ValidEmail;
import com.luv2code.springsecurity.demo.validation.ValidMobileNumber;

@Entity
@Table(name="accounts")
public class Account {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="accountname")
	@NotNull(message="is required")
	@Size(min = 1 ,message = "is required")
	private String accountName;
	
	@Column(name="guarantorname")
	@NotNull(message="is required")
	@Size(min = 1 ,message = "is required")
	private String guarantorName;
	
	@Column(name="HSNnumber")
	private String HsnNumber;

	@Column(name="email")
	@ValidEmail
	private String email;

	@NotNull(message = "is required")
	@ValidMobileNumber
	@Column(name="mobilenumber1")
	private String mobileNumber1;
	
	@Column(name="mobilenumber2")
	@ValidMobileNumber
	private String mobileNumber2;	
	
	@Column(name="PAN")
	@IsPan
	private String pan;
	
	@Column(name="addressline1")
	@NotNull(message="is required")
	@Size(min = 1 ,message = "is required")
	private String addressLine1;
	
	@Column(name="addressline2")
	private String addressLine2;
	
	@Column(name="city")
	@NotNull(message="is required")
	@Size(min = 1 ,message = "is required")
	private String city;
	
	@Column(name="pincode")
	@NotNull(message="is required")
	@Size(min = 1 ,message = "is required")
	@IsPincode
	private String pincode;
	
	
	@Column(name="groupname")
	@NotNull(message="is required")
	private Long groupId;

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getGuarantorName() {
		return guarantorName;
	}

	public void setGuarantorName(String guarantorName) {
		this.guarantorName = guarantorName;
	}

	public String getHsnNumber() {
		return HsnNumber;
	}

	public void setHsnNumber(String hsnNumber) {
		HsnNumber = hsnNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber1() {
		return mobileNumber1;
	}

	public void setMobileNumber1(String mobileNumber1) {
		this.mobileNumber1 = mobileNumber1;
	}

	
	public String getMobileNumber2() {
		return mobileNumber2;
	}

	public void setMobileNumber2(String mobileNumber2) {
		this.mobileNumber2 = mobileNumber2;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", accountName=" + accountName + ", guarantorName=" + guarantorName
				+ ", HsnNumber=" + HsnNumber + ", email=" + email + ", mobileNumber1=" + mobileNumber1
				+ ", mobileNumber2=" + mobileNumber2 + ", pan=" + pan + ", addressLine1=" + addressLine1
				+ ", addressLine2=" + addressLine2 + ", city=" + city + ", pincode=" + pincode + ", groupId=" + groupId
				+ "]";
	}
	public Account() {
		
	}
	public Account(Long id,
			@NotNull(message = "is required") @Size(min = 1, message = "is required") String accountName,
			@NotNull(message = "is required") @Size(min = 1, message = "is required") String guarantorName,
			String hsnNumber, String email, @NotNull(message = "is required") String mobileNumber1,
			String mobileNumber2, String pan,
			@NotNull(message = "is required") @Size(min = 1, message = "is required") String addressLine1,
			String addressLine2, @NotNull(message = "is required") @Size(min = 1, message = "is required") String city,
			@NotNull(message = "is required") @Size(min = 1, message = "is required") String pincode,
			@NotNull(message = "is required") Long groupId) {
		super();
		this.id = id;
		this.accountName = accountName;
		this.guarantorName = guarantorName;
		HsnNumber = hsnNumber;
		this.email = email;
		this.mobileNumber1 = mobileNumber1;
		this.mobileNumber2 = mobileNumber2;
		this.pan = pan;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.pincode = pincode;
		this.groupId = groupId;
	}

}
