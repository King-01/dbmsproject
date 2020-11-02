package com.luv2code.springsecurity.demo.user;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.luv2code.springsecurity.demo.validation.FieldMatch;
import com.luv2code.springsecurity.demo.validation.IsGstin;
import com.luv2code.springsecurity.demo.validation.IsPan;
import com.luv2code.springsecurity.demo.validation.IsPincode;
import com.luv2code.springsecurity.demo.validation.IsValidPassword;
import com.luv2code.springsecurity.demo.validation.ValidEmail;
import com.luv2code.springsecurity.demo.validation.ValidMobileNumber;

@FieldMatch.List({
    @FieldMatch(first = "password", second = "matchingPassword", message = "The password fields must match")
})
public class CrmUser {

	@NotNull(message="is required")
//	@Size(min=5, max = 45, message="Should be atleast 5 characters long")	
	private String userName;

	@NotNull(message = "is required")
	private String password;
	@IsValidPassword
	@NotNull(message = "is required")
	private String matchingPassword;
	@IsPan
	private String pan;
	@IsGstin
	private String gstin;
	
	
	private String tdsAccountNumber;
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String addressLine1;
	
	private String addressLine2;
	@NotNull(message = "is required")
	@Size(min = 1, message = "Should not be empty.")
	private String city;
	@IsPincode
	private String pincode;
	@ValidEmail
	private String email;
	
	@NotNull(message = "is required")
	@ValidMobileNumber
	private String mobilenumber1;
	
	@ValidMobileNumber
	private String mobilenumber2;

	public String getMobilenumber1() {
		return mobilenumber1;
	}

	public void setMobilenumber1(String mobilenumber1) {
		this.mobilenumber1 = mobilenumber1;
	}

	public String getMobilenumber2() {
		return mobilenumber2;
	}

	public void setMobilenumber2(String mobilenumber2) {
		this.mobilenumber2 = mobilenumber2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public CrmUser() {
		
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getGstin() {
		return gstin;
	}

	public void setGstin(String gstin) {
		this.gstin = gstin;
	}

	public String getTdsAccountNumber() {
		return tdsAccountNumber;
	}

	public String getMatchingPassword() {
		return matchingPassword;
	}

	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}
	public void setTdsAccountNumber(String tdsAccountNumber) {
		this.tdsAccountNumber = tdsAccountNumber;
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

	
	
}
