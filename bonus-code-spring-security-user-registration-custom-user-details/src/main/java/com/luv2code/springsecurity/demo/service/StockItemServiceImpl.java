package com.luv2code.springsecurity.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springsecurity.demo.dao.StockItemDao;
import com.luv2code.springsecurity.demo.entity.StockItem;
@Service
public class StockItemServiceImpl implements StockItemService {
	@Autowired
	private StockItemDao stockItemDao;

	@Override
	public StockItem getStockItem(String StockName, Long groupId) {
		// TODO Auto-generated method stub
		return stockItemDao.getStockItem(StockName, groupId);
	}

	@Override
	public void save(StockItem theStockItem) {
		// TODO Auto-generated method stub
		stockItemDao.save(theStockItem);
	}

	@Override
	public List<StockItem> getStockItemByGroupId(Long groupId) {
		// TODO Auto-generated method stub
		return stockItemDao.getStockItemByGroupId(groupId);
	}

	@Override
	public List<StockItem> getStockItemByUserName(String userName) {
		// TODO Auto-generated method stub
		return stockItemDao.getStockItemByUserName(userName);
	}

}
