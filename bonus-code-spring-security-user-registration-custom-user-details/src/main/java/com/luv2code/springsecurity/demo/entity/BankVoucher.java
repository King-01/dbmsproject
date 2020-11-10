package com.luv2code.springsecurity.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bankvoucher")
public class BankVoucher {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="bvoucherid")
	private Long bvoucherId;
	
	@Column(name="date")
	private String date;
	
	@Column(name="credittotal")
	private Double creditTotal;
	
	@Column(name="debittotal")
	private Double debitTotal;
	
	@Column(name="name")
	private String accountName;
	@Column(name="username_id")
	private String userName;
	@Column(name="description")
	private String description;
	public Long getBvoucherId() {
		return bvoucherId;
	}

	@Column(name = "accountid")
	private Long accountId;
	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Double getCreditTotal() {
		return creditTotal;
	}

	public void setCreditTotal(Double creditTotal) {
		this.creditTotal = creditTotal;
	}

	public Double getDebitTotal() {
		return debitTotal;
	}

	public void setDebitTotal(Double debitTotal) {
		this.debitTotal = debitTotal;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getCvoucherId() {
		return bvoucherId;
	}

	@Override
	public String toString() {
		return "BankVoucher [bvoucherId=" + bvoucherId + ", date=" + date + ", creditTotal=" + creditTotal
				+ ", debitTotal=" + debitTotal + ", accountName=" + accountName + ", userName=" + userName
				+ ", description=" + description + ", accountId=" + accountId + "]";
	}
	
	
}
