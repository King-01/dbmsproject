package com.love2code.springsecurity.demo.form;

import java.util.List;

public class ListOfStockPurchaseForm {
	List<StockPurchaseForm> theStockPurchaseFormList;

	@Override
	public String toString() {
		return "ListOfStockPurchaseForm []";
	}

	public List<StockPurchaseForm> getTheStockPurchaseFormList() {
		return theStockPurchaseFormList;
	}

	public void setTheStockPurchaseFormList(List<StockPurchaseForm> theStockPurchaseFormList) {
		this.theStockPurchaseFormList = theStockPurchaseFormList;
	}
	
}
