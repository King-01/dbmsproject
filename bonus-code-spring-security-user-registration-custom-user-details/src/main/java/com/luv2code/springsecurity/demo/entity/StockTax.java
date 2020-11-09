package com.luv2code.springsecurity.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="stock_tax")
public class StockTax {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@NotNull(message = "is required")
	@Column(name="stock_id")
	private Long stockId;
	@NotNull(message = "is required")
	@Column(name="tax_id")
	private Long taxId;

	@Override
	public String toString() {
		return "StockTax [id=" + id + ", stockId=" + stockId + ", taxId=" + taxId + "]";
	}

	public Long getStockId() {
		return stockId;
	}

	public void setStockId(Long stockId) {
		this.stockId = stockId;
	}

	public Long getTaxId() {
		return taxId;
	}

	public void setTaxId(Long taxId) {
		this.taxId = taxId;
	}

	public Long getId() {
		return id;
	}
	
	
	
}
