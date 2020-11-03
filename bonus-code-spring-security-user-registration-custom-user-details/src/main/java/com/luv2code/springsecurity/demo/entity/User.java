package com.luv2code.springsecurity.demo.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "displayname")
	private String displayName;
	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	@Column(name = "username")
	private String userName;

	@Column(name = "password")
	private String password;

	@Column(name = "pan")
	private String pan;

	@Column(name = "gstin")
	private String gstin;

	@Column(name = "addressline1")
	private String addressLine1;

	@Column(name = "tdsAccountNumber")
	private String tdsAccountNumber;

	@Column(name = "addressline2")
	private String addressLine2;

	@Column(name = "city")
	private String city;

	@Column(name = "pincode")
	private String pincode;
	@Column(name = "email")
	private String email;
	@Column(name = "mobilenumber1")
	private String MobileNumber1;
	@Column(name = "mobilenumber2")
	private String MobileNumber2;
	public String getMobileNumber1() {
		return MobileNumber1;
	}

	public void setMobileNumber1(String mobileNumber1) {
		MobileNumber1 = mobileNumber1;
	}

	public String getMobileNumber2() {
		return MobileNumber2;
	}

	public void setMobileNumber2(String mobileNumber2) {
		MobileNumber2 = mobileNumber2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "users_roles", 
	joinColumns = @JoinColumn(name = "user_id"), 
	inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Collection<Role> roles;

	public User() {
	}

	public User(String userName, String password, String pan, String gstin, String tdsAccountNumber, String pincode, String city, String addressLine1, String addressLine2) {
		this.userName = userName;
		this.password = password;
		this.pan = pan;
		this.gstin = gstin;
		this.tdsAccountNumber = tdsAccountNumber;
		this.pincode = pincode;
		this.city = city;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
	}

	public User(String userName, String password, String pan, String gstin, String tdsAccountNumber, String pincode, String city, String addressLine1, String addressLine2,
			Collection<Role> roles) {
		this.userName = userName;
		this.password = password;
		this.pan = pan;
		this.gstin = gstin;
		this.tdsAccountNumber = tdsAccountNumber;
		this.pincode = pincode;
		this.city = city;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.roles = roles;
	}

	public User(Long id, String displayName, String userName, String password, String pan, String gstin,
			String addressLine1, String tdsAccountNumber, String addressLine2, String city, String pincode,
			String email, String mobileNumber1, String mobileNumber2, Collection<Role> roles) {
		super();
		this.id = id;
		this.displayName = displayName;
		this.userName = userName;
		this.password = password;
		this.pan = pan;
		this.gstin = gstin;
		this.addressLine1 = addressLine1;
		this.tdsAccountNumber = tdsAccountNumber;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.pincode = pincode;
		this.email = email;
		MobileNumber1 = mobileNumber1;
		MobileNumber2 = mobileNumber2;
		this.roles = roles;
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

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getTdsAccountNumber() {
		return tdsAccountNumber;
	}

	public void setTdsAccountNumber(String tdsAccountNumber) {
		this.tdsAccountNumber = tdsAccountNumber;
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

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", displayName=" + displayName + ", userName=" + userName + ", password=" + password
				+ ", pan=" + pan + ", gstin=" + gstin + ", addressLine1=" + addressLine1 + ", tdsAccountNumber="
				+ tdsAccountNumber + ", addressLine2=" + addressLine2 + ", city=" + city + ", pincode=" + pincode
				+ ", email=" + email + ", MobileNumber1=" + MobileNumber1 + ", MobileNumber2=" + MobileNumber2
				+ ", roles=" + roles + "]";
	}
	
}
