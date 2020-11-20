package com.love2code.springsecurity.demo.form;

import com.luv2code.springsecurity.demo.entity.StockItem;

public class StockItemForm1 {
	private Long id;
	
	private String stockItemName;
	
	private String hsnGroup;
	
	private String mandiTax;
	
	private String kkFee;
	
	private String commision;
	
	private String labourCharge;

	private String packing;
	
	private Long groupId;
	
	private Long quantity;
	private long stockTaxId;
	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "StockItemForm [id=" + id + ", stockItemName=" + stockItemName + ", hsnGroup=" + hsnGroup + ", mandiTax="
				+ mandiTax + ", kkFee=" + kkFee + ", commision=" + commision + ", labourCharge=" + labourCharge
				+ ", packing=" + packing + ", groupId=" + groupId + ", quantity=" + quantity + ", stockTaxId="
				+ stockTaxId + "]";
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

	public Long getId() {
		return id;
	}
	public StockItemForm1 createStockItem(StockItem st)
	{
		StockItemForm1 toret = new StockItemForm1();
		toret.setCommision(st.getCommision());
		toret.setGroupId(st.getGroupId());
		toret.setHsnGroup(st.getHsnGroup());
		toret.setKkFee(st.getKkFee());
		toret.setLabourCharge(st.getLabourCharge());
		toret.setMandiTax(st.getMandiTax());
		toret.setPacking(st.getPacking());
		toret.setStockItemName(st.getStockItemName());
		toret.setQuantity((long) 0);
		toret.setId(st.getId());
		return toret;
	}

	public long getStockTaxId() {
		return stockTaxId;
	}

	public void setStockTaxId(long stockTaxId) {
		this.stockTaxId = stockTaxId;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
