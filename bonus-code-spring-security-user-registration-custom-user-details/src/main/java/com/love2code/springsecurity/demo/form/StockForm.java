package com.love2code.springsecurity.demo.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.luv2code.springsecurity.demo.entity.StockItem;
import com.luv2code.springsecurity.demo.validation.IsPercentage;

public class StockForm {
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String stockItemName;
	
	@Size(min = 1, message="is required")
	private String hsnGroup;
	@IsPercentage
	@NotNull(message = "is required")
	private String mandiTax;
	@IsPercentage
	@NotNull(message = "is required")
	private String kkFee;
	
	@IsPercentage
	@NotNull(message = "is required")
	private String commision;
	
	@IsPercentage
	@NotNull(message = "is required")
	private String labourCharge;
	
	@IsPercentage
	@NotNull(message = "is required")
	private String packing;
	@NotNull(message="is required")
	private Long groupId;
	public StockForm()
	{
		
	}
	public StockForm createStockForm(StockItem st)
	{
		StockForm toret = new StockForm();
		toret.stockItemName = st.getStockItemName();
		toret.groupId = st.getGroupId();
		toret.hsnGroup = st.getHsnGroup();
		toret.labourCharge = st.getLabourCharge();
		toret.packing = st.getPacking();
		toret.commision = st.getCommision();
		toret.kkFee = st.getKkFee();
		toret.mandiTax = st.getMandiTax();
		return toret;
	}

	
	public String getStockItemName() {
		return stockItemName;
	}

	public void setStockItemName(String stockItemName) {
		this.stockItemName = stockItemName;
	}

	public String getHsnGroup() {
		return hsnGroup;
	}

	public void setHsnGroup(String hsnGroup) {
		this.hsnGroup = hsnGroup;
	}


	public String getMandiTax() {
		return mandiTax;
	}
	public void setMandiTax(String mandiTax) {
		this.mandiTax = mandiTax;
	}
	public String getKkFee() {
		return kkFee;
	}
	public void setKkFee(String kkFee) {
		this.kkFee = kkFee;
	}
	public String getCommision() {
		return commision;
	}
	public void setCommision(String commision) {
		this.commision = commision;
	}
	public String getLabourCharge() {
		return labourCharge;
	}
	public void setLabourCharge(String labourCharge) {
		this.labourCharge = labourCharge;
	}
	public String getPacking() {
		return packing;
	}
	public void setPacking(String packing) {
		this.packing = packing;
	}
	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	@Override
	public String toString() {
		return "StockForm [stockItemName=" + stockItemName + ", hsnGroup=" + hsnGroup + ", mandiTax=" + mandiTax
				+ ", kkFee=" + kkFee + ", commision=" + commision + ", labourCharge=" + labourCharge + ", packing="
				+ packing + ", groupId=" + groupId + "]";
	}
	
}
