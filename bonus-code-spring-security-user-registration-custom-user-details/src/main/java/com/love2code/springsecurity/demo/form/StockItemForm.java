package com.love2code.springsecurity.demo.form;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.luv2code.springsecurity.demo.entity.StockItem;

public class StockItemForm {
	@NotNull(message = "is required")
	List<StockItem> stockitems;
	public StockItemForm()
	{
		
	}
	public List<StockItem> getStockitems() {
		return stockitems;
	}
	public void setStockitems(List<StockItem> stockitems) {
		this.stockitems = stockitems;
	}
	@Override
	public String toString() {
		return "StockItemForm []";
	}

}
