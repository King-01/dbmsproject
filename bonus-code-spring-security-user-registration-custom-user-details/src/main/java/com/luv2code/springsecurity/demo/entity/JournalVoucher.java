package com.luv2code.springsecurity.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.luv2code.springsecurity.demo.validation.IsDecimal;

@Entity
@Table(name="journalvoucher")
public class JournalVoucher {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="jvoucherid")
	private Long jvoucherId;
	
	@Column(name="date")
    @Temporal(TemporalType.DATE)
	@NotNull(message = "is required")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	@NotNull(message = "is required")
	@Column(name="credittotal")
	private Double creditTotal;
	@IsDecimal
	@NotNull(message = "is required")
	@Column(name="debittotal")
	private Double debitTotal;

	@NotNull(message = "is required")
	@Column(name="accountid")
	private Long accountId;
	
	@Column(name="name")
	private String accountName;
	
	@NotNull(message = "is required")
	@Column(name="username_id")
	@Size(min = 1, message = "is required")
	private String userName;
	


	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	@Column(name="description")
	private String description;
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
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

	public Long getJvoucherId() {
		return jvoucherId;
	}

	@Override
	public String toString() {
		return "JournalVoucher [jvoucherId=" + jvoucherId + ", date=" + date + ", creditTotal=" + creditTotal
				+ ", debitTotal=" + debitTotal + ", accountId=" + accountId + ", accountName=" + accountName
				+ ", userName=" + userName + ", description=" + description + "]";
	}
	
	
}
