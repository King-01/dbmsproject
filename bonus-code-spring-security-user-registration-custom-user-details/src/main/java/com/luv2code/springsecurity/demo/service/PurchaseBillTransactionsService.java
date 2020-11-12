package com.luv2code.springsecurity.demo.service;

import java.util.List;

import com.luv2code.springsecurity.demo.entity.PurchaseBillTransactions;

public interface PurchaseBillTransactionsService {

    PurchaseBillTransactions getPurchaseBillVoucherTransactionsById(Long id);
    List<PurchaseBillTransactions> getPurchaseBillVoucherTransactions(Long pvoucherid);
    
    void save(PurchaseBillTransactions toSave);
}
