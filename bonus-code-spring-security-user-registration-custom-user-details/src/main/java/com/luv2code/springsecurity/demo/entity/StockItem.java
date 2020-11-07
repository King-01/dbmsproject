package com.luv2code.springsecurity.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.love2code.springsecurity.demo.form.StockForm;

@Entity
@Table(name="stockitem")
public class StockItem {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="itemname")
	private String stockItemName;
	
	@Column(name="hsngroup")
	private String hsnGroup;
	
	@Column(name="manditax")
	private String mandiTax;
	
	@Column(name="kkfee")
	private String kkFee;
	
	@Column(name="commision")
	private String commision;
	
	@Column(name="labourcharge")
	private String labourCharge;
	
	@Column(name="packing")
	private String packing;
	
	@Column(name="groupname")
	private Long groupId;

	@Override
	public String toString() {
		return "StockItem [id=" + id + ", stockItemName=" + stockItemName + ", hsnGroup=" + hsnGroup + ", mandiTax="
				+ mandiTax + ", kkFee=" + kkFee + ", commision=" + commision + ", labourCharge=" + labourCharge
				+ ", packing=" + packing + ", groupId=" + groupId + "]";
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
	public StockItem createStockItem(StockForm st)
	{
		StockItem toret = new StockItem();
		toret.setCommision(st.getCommision());
		toret.setGroupId(st.getGroupId());
		toret.setHsnGroup(st.getHsnGroup());
		toret.setKkFee(st.getKkFee());
		toret.setLabourCharge(st.getLabourCharge());
		toret.setMandiTax(st.getMandiTax());
		toret.setPacking(st.getPacking());
		toret.setStockItemName(st.getStockItemName());
		return toret;
	}
	
	
	
}
