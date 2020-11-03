package com.luv2code.springsecurity.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="accounts")
public class Account {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private String id;
	
	@Column(name="accountname")
	private String accountName;
	
	@Column(name="guarantorname")
	private String guarantorName;
	
	@Column(name="HSNnumber")
	private String HsnNumber;

	@Column(name="email")
	private String email;
	
	@Column(name="mobilenumber1")
	private String mobileNumber1;
	
	@Column(name="mobilenumber2")
	private String mobileNumber2;	
	
	@Column(name="PAN")
	private String pan;
	
	@Column(name="addressline1")
	private String addressLine1;
	
	@Column(name="addressline2")
	private String addressLine2;
	
	@Column(name="city")
	private String city;
	
	@Column(name="pincode")
	private String pincode;
	
	@Column(name="username_id")
	private String userName;
	
	@Column(name="groupname")
	private String groupName;

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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", accountName=" + accountName + ", guarantorName=" + guarantorName
				+ ", HsnNumber=" + HsnNumber + ", email=" + email + ", mobileNumber1=" + mobileNumber1
				+ ", mobileNumber2=" + mobileNumber2 + ", pan=" + pan + ", addressLine1=" + addressLine1
				+ ", addressLine2=" + addressLine2 + ", city=" + city + ", pincode=" + pincode + ", userName="
				+ userName + ", groupName=" + groupName + "]";
	}

}
