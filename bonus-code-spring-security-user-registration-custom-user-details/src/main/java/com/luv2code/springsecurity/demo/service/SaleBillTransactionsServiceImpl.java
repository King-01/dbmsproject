package com.luv2code.springsecurity.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springsecurity.demo.dao.SaleBillTransactionsDao;
import com.luv2code.springsecurity.demo.entity.SaleBillTransactions;
@Service
public class SaleBillTransactionsServiceImpl implements SaleBillTransactionsService {
    @Autowired
    private SaleBillTransactionsDao saleBillTransactionsDao;

    @Override
    public SaleBillTransactions getSaleBillTransactionsById(Long id) {
        // TODO Auto-generated method stub
        return saleBillTransactionsDao.getSaleBillTransactionsById(id);
    }

    @Override
    public List<SaleBillTransactions> getSaleBillTransactions(Long svoucherid) {
        // TODO Auto-generated method stub
        return saleBillTransactionsDao.getSaleBillTransactions(svoucherid);
    }

    @Override
    public void save(SaleBillTransactions toSave) {
        // TODO Auto-generated method stub
        saleBillTransactionsDao.save(toSave);
    }

   

}
