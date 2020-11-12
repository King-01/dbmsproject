package com.love2code.springsecurity.demo.form;

import java.util.List;

public class ListOfStockSaleForm {
  List<StockSaleForm> theStockSaleFormList;

  @Override
  public String toString() {
    return "ListOfStockSaleForm []";
  }

  public List<StockSaleForm> getTheStockSaleFormList() {
    return theStockSaleFormList;
  }

  public void setTheStockSaleFormList(List<StockSaleForm> theStockSaleFormList) {
    this.theStockSaleFormList = theStockSaleFormList;
  }
  
}
