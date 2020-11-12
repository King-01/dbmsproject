package com.luv2code.springsecurity.demo.dao;

import java.util.List;

import com.luv2code.springsecurity.demo.entity.PurchaseBillTransactions;

public interface PurchaseBillVoucherTransactionsDao {
    PurchaseBillTransactions getPurchaseBillVoucherTransactionsById(Long id);
    List<PurchaseBillTransactions> getPurchaseBillVoucherTransactions(Long pvoucherid);
    
    void save(PurchaseBillTransactions toSave);
}
