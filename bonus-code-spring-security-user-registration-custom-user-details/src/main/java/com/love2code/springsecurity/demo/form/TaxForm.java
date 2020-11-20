package com.love2code.springsecurity.demo.form;

import com.luv2code.springsecurity.demo.entity.Tax;

public class TaxForm {
	private Long id;
	private String TaxName;
	
	private String taxPercent;
	
	private Long userid;
	private long stockTaxId;
	@Override
	public String toString() {
		return "TaxForm [id=" + id + ", TaxName=" + TaxName + ", taxPercent=" + taxPercent + ", userid=" + userid
				+ ", stockTaxId=" + stockTaxId + "]";
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

	public String getTaxName() {
		return TaxName;
	}

	public void setTaxName(String taxName) {
		TaxName = taxName;
	}

	public String getTaxPercent() {
		return taxPercent;
	}

	public void setTaxPercent(String taxPercent) {
		this.taxPercent = taxPercent;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public Long getId() {
		return id;
	}
	public TaxForm ()
	{
		
	}
	public TaxForm (Tax itm)
	{
		this.id = itm.getId();
		this.TaxName = itm.getTaxName();
		this.taxPercent = itm.getTaxPercent();
		this.userid = itm.getUserid();
	}
	
	
}
