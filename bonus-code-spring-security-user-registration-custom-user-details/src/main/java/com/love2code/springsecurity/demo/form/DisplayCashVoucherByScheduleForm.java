package com.love2code.springsecurity.demo.form;

public class DisplayCashVoucherByScheduleForm {
	private Long id;
	
	private String accountName;
	
	private String guarantorName;
	
	private String HsnNumber;

	private String email;

	private String mobileNumber1;
	
	private String mobileNumber2;	
	
	private String pan;
	
	private String addressLine1;
	
	private String addressLine2;
	
	private String city;
	
	private String pincode;
	
	private Long groupId;
	
	private String groupName;

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
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
		return "DisplayAccountByScheduleForm [id=" + id + ", accountName=" + accountName + ", guarantorName="
				+ guarantorName + ", HsnNumber=" + HsnNumber + ", email=" + email + ", mobileNumber1=" + mobileNumber1
				+ ", mobileNumber2=" + mobileNumber2 + ", pan=" + pan + ", addressLine1=" + addressLine1
				+ ", addressLine2=" + addressLine2 + ", city=" + city + ", pincode=" + pincode + ", groupId=" + groupId
				+ ", groupName=" + groupName + "]";
	}
	
}
