package com.love2code.springsecurity.demo.form;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class DateForm {
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;
	private Long accountId;
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	@Override
	public String toString() {
		return "DateForm [startDate=" + startDate + ", endDate=" + endDate + ", accountId=" + accountId + "]";
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
}
