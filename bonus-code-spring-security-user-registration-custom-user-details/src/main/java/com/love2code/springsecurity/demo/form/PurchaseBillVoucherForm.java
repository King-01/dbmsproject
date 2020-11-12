package com.love2code.springsecurity.demo.form;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class PurchaseBillVoucherForm {
	@Column(name="currdate")
    @Temporal(TemporalType.DATE)
	@NotNull(message = "is required")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	@Column(name="cost")
	private Double cost;
	@NotNull(message = "is required")
	@Column(name="supplierid")
	private Long accountId;
	@Column(name="description")
	private String description;
	@Column(name="suppliername")
	private String accountName;
	@Column(name="trucknumber")
	private String trucknumber;
	private List<StockPurchaseForm> theform;
	public List<StockPurchaseForm> getTheform() {
		return theform;
	}

	public void setTheform(List<StockPurchaseForm> theform) {
		this.theform = theform;
	}

	public String getTrucknumber() {
		return trucknumber;
	}

	public void setTrucknumber(String trucknumber) {
		this.trucknumber = trucknumber;
	}

	@NotNull(message = "is required")
	@Column(name="username_id")
	@Size(min = 1, message = "is required")
	private String userName;

	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}



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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	@Override
	public String toString() {
		return "PurchaseBillVoucherForm [date=" + date + ", cost=" + cost + ", accountId=" + accountId
				+ ", description=" + description + ", accountName=" + accountName + ", trucknumber=" + trucknumber
				+ ", theform=" + theform + ", userName=" + userName + "]";
	}

}