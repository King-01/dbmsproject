package com.luv2code.springsecurity.demo.service;

import java.util.List;

import com.luv2code.springsecurity.demo.entity.StockTax;

public interface StockTaxService {
	StockTax getStockTax(Long stId, Long tId);
	void save(StockTax toSave);
	List<StockTax> getStockTaxByStockId(Long theId);
	List<StockTax> getStockTaxByTaxId(Long theId);
	List<StockTax> getStockTaxByUserName(String userName);
	List<StockTax> getTaxByStockId(Long theId);
	List<StockTax> getStockItemByTaxId(Long theId);
}
