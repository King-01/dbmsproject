package com.luv2code.springsecurity.demo.service;

import java.util.List;

import com.luv2code.springsecurity.demo.entity.StockItem;

public interface StockItemService {

	StockItem getStockItem(String StockName, Long groupId);
	StockItem getStockItem(String StockName, String userName);
	
	void save(StockItem theStockItem);
	
	List<StockItem> getStockItemByGroupId(Long groupId);
	List<StockItem> getStockItemByUserName(String userName);
	StockItem get(Long id);
}
