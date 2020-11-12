package com.luv2code.springsecurity.demo.service;

import java.util.List;

import com.luv2code.springsecurity.demo.entity.SaleBillTransactions;

public interface SaleBillTransactionsService {

    SaleBillTransactions getSaleBillTransactionsById(Long id);
    List<SaleBillTransactions> getSaleBillTransactions(Long svoucherid);
    
    void save(SaleBillTransactions toSave);
}
