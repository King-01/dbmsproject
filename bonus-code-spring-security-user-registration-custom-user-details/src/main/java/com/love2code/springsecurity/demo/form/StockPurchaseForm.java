package com.love2code.springsecurity.demo.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.luv2code.springsecurity.demo.validation.IsDecimal;
import com.luv2code.springsecurity.demo.validation.IsNumber;

public class StockPurchaseForm {
	Long id;
	@NotNull(message="is required")
	@Size(min = 1, message = "is required")
	String stockitemName;
	@NotNull(message = "is required")
	Long stockitemquantity;
	@NotNull(message="is required")
	@IsNumber
    Long quantity;
	@NotNull(message="is required")
	@IsDecimal
    Double rate;
	Double tax;
	Double total;
	String taxbreakup;
	public String getTaxbreakup() {
		return taxbreakup;
	}


	public void setTaxbreakup(String taxbreakup) {
		this.taxbreakup = taxbreakup;
	}


	public Double getTax() {
		return tax;
	}


	public void setTax(Double tax) {
		this.tax = tax;
	}


	public Double getTotal() {
		return total;
	}


	public void setTotal(Double total) {
		this.total = total;
	}


	public Long getStockitemquantity() {
		return stockitemquantity;
	}


	public void setStockitemquantity(Long stockitemquantity) {
		this.stockitemquantity = stockitemquantity;
	}
	public StockPurchaseForm() {
        rate = 0.0;
        quantity = (long) 0;
    }

   
    public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getStockitemName() {
		return stockitemName;
	}


	public void setStockitemName(String stockitemName) {
		this.stockitemName = stockitemName;
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
    @Override
	public String toString() {
		return "StockPurchaseForm [id=" + id + ", stockitemName=" + stockitemName + ", stockitemquantity="
				+ stockitemquantity + ", quantity=" + quantity + ", rate=" + rate + ", tax=" + tax + ", total=" + total
				+ ", taxbreakup=" + taxbreakup + "]";
	}

}