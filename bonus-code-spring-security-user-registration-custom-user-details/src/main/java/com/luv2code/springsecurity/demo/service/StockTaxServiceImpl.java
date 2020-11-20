package com.luv2code.springsecurity.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springsecurity.demo.dao.StockTaxDao;
import com.luv2code.springsecurity.demo.entity.StockTax;
@Service
public class StockTaxServiceImpl implements StockTaxService {
	@Autowired
	private StockTaxDao stockTaxDao;

	@Override
	public StockTax getStockTax(Long stId, Long tId) {
		// TODO Auto-generated method stub
		return stockTaxDao.getStockTax(stId, tId);
	}

	@Override
	public void save(StockTax toSave) {
		// TODO Auto-generated method stub
		stockTaxDao.save(toSave);
	}

	@Override
	public List<StockTax> getStockTaxByStockId(Long theId) {
		// TODO Auto-generated method stub
		return stockTaxDao.getStockTaxByStockId(theId);
	}

	@Override
	public List<StockTax> getStockTaxByTaxId(Long theId) {
		// TODO Auto-generated method stub
		return stockTaxDao.getStockTaxByTaxId(theId);
	}

	@Override
	public List<StockTax> getStockTaxByUserName(String userName) {
		// TODO Auto-generated method stub
		return stockTaxDao.getStockTaxByUserName(userName);
	}

	@Override
	public List<StockTax> getTaxByStockId(Long theId) {
		// TODO Auto-generated method stub
		return stockTaxDao.getTaxByStockId(theId);
	}

	@Override
	public List<StockTax> getStockItemByTaxId(Long theId) {
		// TODO Auto-generated method stub
		return stockTaxDao.getStockItemByTaxId(theId);
	}

	@Override
	public StockTax getById(Long id) {
		// TODO Auto-generated method stub
		return stockTaxDao.getById(id);
	}

	@Override
	public int delete(StockTax itm) {
		// TODO Auto-generated method stub
		return stockTaxDao.delete(itm);
	}



}
