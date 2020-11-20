package com.luv2code.springsecurity.demo.dao;

import java.util.List;

import com.luv2code.springsecurity.demo.entity.StockItem;
import com.luv2code.springsecurity.demo.entity.StockTax;
import com.luv2code.springsecurity.demo.entity.Tax;

public interface StockTaxDao {
	StockTax getStockTax(Long stId, Long tId);
	void save(StockTax toSave);
	List<StockTax> getStockTaxByStockId(Long theId);
	List<StockTax> getStockTaxByTaxId(Long theId);
	List<StockTax> getStockTaxByUserName(String userName);
	List<StockTax> getTaxByStockId(Long theId);
	List<StockTax> getStockItemByTaxId(Long theId);
	StockTax getById(long id);
	int delete(StockTax itm);
}
