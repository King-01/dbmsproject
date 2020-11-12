package com.love2code.springsecurity.demo.form;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class PurchaseBillForm {
    @NotNull(message="is required")
    @Valid
    List < StockPurchaseForm > theList;
    long accountId;
    @NotNull(message="is required")
    Date date;
    String description;
    public PurchaseBillForm()
    {
    	theList = new ArrayList<StockPurchaseForm>();
    	date = new Date();
    	description = null;
    	
    }
    public PurchaseBillForm(int sz)
    {
    	theList = new ArrayList<StockPurchaseForm>(sz);
    	date = new Date();
    	description = null;
    }
    public List<StockPurchaseForm> getTheList() {
		return theList;
	}

	public void setTheList(List<StockPurchaseForm> theList) {
		this.theList = theList;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    @Override
	public String toString() {
		return "PurchaseBillForm [theList=" + theList + ", accountId=" + accountId + ", date=" + date + ", description="
				+ description + "]";
	}

}