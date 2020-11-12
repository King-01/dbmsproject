package com.luv2code.springsecurity.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springsecurity.demo.dao.PurchaseBillVoucherTransactionsDao;
import com.luv2code.springsecurity.demo.entity.PurchaseBillTransactions;
@Service
public class PurchaseBillTransactionsServiceImpl implements PurchaseBillTransactionsService {
    @Autowired
    private PurchaseBillVoucherTransactionsDao purchaseBillTransactionsDao;

	@Override
	public PurchaseBillTransactions getPurchaseBillVoucherTransactionsById(Long id) {
		// TODO Auto-generated method stub
		return purchaseBillTransactionsDao.getPurchaseBillVoucherTransactionsById(id);
	}

	@Override
	public List<PurchaseBillTransactions> getPurchaseBillVoucherTransactions(Long pvoucherid) {
		// TODO Auto-generated method stub
		return purchaseBillTransactionsDao.getPurchaseBillVoucherTransactions(pvoucherid);
	}

	@Override
	public void save(PurchaseBillTransactions toSave) {
		// TODO Auto-generated method stub
		purchaseBillTransactionsDao.save(toSave);
	}

   

}
