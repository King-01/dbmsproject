package com.luv2code.springsecurity.demo.user;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.luv2code.springsecurity.demo.validation.IsPan;
import com.luv2code.springsecurity.demo.validation.IsPincode;
import com.luv2code.springsecurity.demo.validation.ValidEmail;
import com.luv2code.springsecurity.demo.validation.ValidMobileNumber;

public class AccountUser {
	@NotNull(message="is required")
	@Size(min = 1, message="is required")
	private String accountName;
	
	@NotNull(message="is required")
	@Size(min = 1, message="is required")
	private String guarantorName;
	
	@NotNull(message="is required")
	@Size(min = 1, message="is required")
	private String HsnNumber;
	@ValidEmail
	private String email;

	@ValidMobileNumber
	@NotNull(message="is required")
	private String mobileNumber1;
	@ValidMobileNumber
	private String mobileNumber2;	
	@IsPan
	private String pan;
	
	@NotNull(message="is required")
	@Size(min = 1, message="is required")
	private String addressLine1;
	
	private String addressLine2;
	
	private String city;
	
	@IsPincode
	private String pincode;
	
	@NotNull(message="is required")
	@Size(min = 1, message="is required")
	private String userName;
	
	@NotNull(message="is required")
	@Size(min = 1, message="is required")
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


	
}
