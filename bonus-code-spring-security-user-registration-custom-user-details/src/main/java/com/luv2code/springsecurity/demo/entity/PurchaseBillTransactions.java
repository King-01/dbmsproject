package com.luv2code.springsecurity.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="purchaseitems")
public class PurchaseBillTransactions {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	@Column(name="quantity")
	private Long quantity;
	@Column(name="rate")
	private Double rate;
	@Column(name="taxbreakup")
	private String taxBreakup;

	@Column(name="itemname")
	private String itemName;

	@Column(name = "totalamount")
	private Double totalAmount;
	@Column(name = "tax")
	private Double tax;
	
	public Double getTax() {
		return tax;
	}
	public void setTax(Double tax) {
		this.tax = tax;
	}


	@ManyToOne(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="pvoucherid")
	private PurchaseBillVoucher purchaseBillVoucher;
    

	public PurchaseBillVoucher getPurchaseBillVoucher() {
		return purchaseBillVoucher;
	}
	public void setPurchaseBillVoucher(PurchaseBillVoucher purchaseBillVoucher) {
		this.purchaseBillVoucher = purchaseBillVoucher;
	}
	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public Long getId() {
		return id;
	}

	public String getTaxBreakup() {
		return taxBreakup;
	}
	public void setTaxBreakup(String taxBreakup) {
		this.taxBreakup = taxBreakup;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	
	@Override
	public String toString() {
		return "PurchaseBillTransactions [id=" + id + ", quantity=" + quantity + ", rate=" + rate + ", taxBreakup="
				+ taxBreakup + ", itemName=" + itemName + ", totalAmount=" + totalAmount + ", tax=" + tax
				+ ", purchaseBillVoucher=" + purchaseBillVoucher + "]";
	}
}