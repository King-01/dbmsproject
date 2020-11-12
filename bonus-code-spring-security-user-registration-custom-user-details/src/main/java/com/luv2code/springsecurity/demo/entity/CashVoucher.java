package com.luv2code.springsecurity.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.luv2code.springsecurity.demo.validation.IsDecimal;

@Entity
@Table(name="cashvoucher")
public class CashVoucher {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cvoucherid")
	private Long cvoucherId;

	@NotNull(message = "is required")
	@Column(name="date")
	private String date;

	@NotNull(message = "is required")
	@Column(name="credittotal")
	@IsDecimal
	private Double creditTotal;

	@NotNull(message = "is required")
	@Column(name="debittotal")
	@IsDecimal
	private Double debitTotal;
	
	@Column(name="name")
	private String accountName;
	@NotNull(message = "is required")
	@Column(name="accountid")
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

	public Long getCvoucherId() {
		return cvoucherId;
	}

	@Column(name="description")
	private String description;
	
	@Column(name="username_id")
	@NotNull(message = "is required")
	private String userName;

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

	@Override
	public String toString() {
		return "CashVoucher [cvoucherId=" + cvoucherId + ", date=" + date + ", creditTotal=" + creditTotal
				+ ", debitTotal=" + debitTotal + ", accountName=" + accountName + ", accountId=" + accountId
				+ ", description=" + description + ", userName=" + userName + "]";
	}
	
	
}
