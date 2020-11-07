package com.luv2code.springsecurity.demo.dao;

import java.util.List;

import com.luv2code.springsecurity.demo.entity.StockItem;

public interface StockItemDao {
	void save(StockItem theStockItem);
	List<StockItem> getStockItemByGroupId(Long groupId);
	StockItem getStockItem(String StockItemName, Long groupId);
	List<StockItem> getStockItemByUserName(String UserName);
}
