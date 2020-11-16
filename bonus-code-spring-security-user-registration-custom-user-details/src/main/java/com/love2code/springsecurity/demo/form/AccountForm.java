package com.love2code.springsecurity.demo.form;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.luv2code.springsecurity.demo.entity.Account;
import com.luv2code.springsecurity.demo.validation.IsPan;
import com.luv2code.springsecurity.demo.validation.IsPincode;
import com.luv2code.springsecurity.demo.validation.IsValidPassword;
import com.luv2code.springsecurity.demo.validation.ValidEmail;
import com.luv2code.springsecurity.demo.validation.ValidMobileNumber;

public class AccountForm {
	public AccountForm(Account theg) {
		this.accountName = theg.getAccountName();
		this.addressLine1 = theg.getAddressLine1();
		this.addressLine2 = theg.getAddressLine2();
		this.city = theg.getCity();
		this.email = theg.getEmail();
		this.HsnNumber = theg.getHsnNumber();
		this.pan = theg.getPan();
		this.pincode = theg.getPincode();
		this.guarantorName = theg.getGuarantorName();
		this.mobileNumber1 = theg.getMobileNumber1();
		this.mobileNumber2 = theg.getMobileNumber2();
		this.prev = this.accountName;
	}
	public String getPrev() {
		return prev;
	}
	public void setPrev(String prev) {
		this.prev = prev;
	}
	@NotNull(message="is required")
	@IsValidPassword
	private String confirmPassword;
	public String getConfirmPassword() {
		return confirmPassword;
	}
	private String prev;
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	@NotNull(message="is required")
	@Size(min = 1 ,message = "is required")
	private String accountName;
	@NotNull(message="is required")
	@Size(min = 1 ,message = "is required")
	private String guarantorName;
	private String HsnNumber;
	@Column(name="email")
	@ValidEmail
	private String email;

	@NotNull(message = "is required")
	@ValidMobileNumber
	private String mobileNumber1;
	
	@ValidMobileNumber
	private String mobileNumber2;
	@IsPan
	private String pan;	
	@NotNull(message="is required")
	@Size(min = 1 ,message = "is required")
	private String addressLine1;
	@Column(name="addressline2")
	private String addressLine2;
	@NotNull(message="is required")
	@Size(min = 1 ,message = "is required")
	private String city;
	@NotNull(message="is required")
	@Size(min = 1 ,message = "is required")
	@IsPincode
	private String pincode;
	
	@Override
	public String toString() {
		return "AccountForm [confirmPassword=" + confirmPassword + ", prev=" + prev + ", accountName=" + accountName
				+ ", guarantorName=" + guarantorName + ", HsnNumber=" + HsnNumber + ", email=" + email
				+ ", mobileNumber1=" + mobileNumber1 + ", mobileNumber2=" + mobileNumber2 + ", pan=" + pan
				+ ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", city=" + city + ", pincode="
				+ pincode + "]";
	}
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
	public AccountForm() {
	}
	
}
