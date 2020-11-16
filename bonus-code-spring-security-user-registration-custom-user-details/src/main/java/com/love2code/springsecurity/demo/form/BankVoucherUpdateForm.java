package com.love2code.springsecurity.demo.form;

import javax.validation.constraints.NotNull;

import com.luv2code.springsecurity.demo.entity.BankVoucher;
import com.luv2code.springsecurity.demo.validation.IsDecimal;

public class BankVoucherUpdateForm {
	@NotNull(message = "is required")
	private Long bvoucherId;
	
	@NotNull(message = "is required")
	private String date;

	@IsDecimal
	@NotNull(message = "is required")
	private Double creditTotal;
	@NotNull(message = "is required")
	@IsDecimal
	private Double debitTotal;
	private String accountName;
	private String userName;
	private String description;
	public Long getBvoucherId() {
		return bvoucherId;
	}
	@NotNull(message = "is required")
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
	public BankVoucherUpdateForm(Long bvoucherId, String date, Double creditTotal, Double debitTotal,
			String accountName, String userName, String description, Long accountId) {
		super();
		this.bvoucherId = bvoucherId;
		this.date = date;
		this.creditTotal = creditTotal;
		this.debitTotal = debitTotal;
		this.accountName = accountName;
		this.userName = userName;
		this.description = description;
		this.accountId = accountId;
	}

	public BankVoucherUpdateForm() {
		super();
	}
	public BankVoucherUpdateForm(BankVoucher bv) {
		this.bvoucherId = bv.getBvoucherId();
		this.date = bv.getDate();
		this.creditTotal = bv.getCreditTotal();
		this.debitTotal = bv.getDebitTotal();
		this.userName = bv.getUserName();
		this.accountId = bv.getAccountId();
		this.accountName = bv.getAccountName();
		this.description = bv.getDescription();
	}

	@Override
	public String toString() {
		return "BankVoucher [bvoucherId=" + bvoucherId + ", date=" + date + ", creditTotal=" + creditTotal
				+ ", debitTotal=" + debitTotal + ", accountName=" + accountName + ", userName=" + userName
				+ ", description=" + description + ", accountId=" + accountId + "]";
	}
	
	
}
