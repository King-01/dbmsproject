package com.luv2code.springsecurity.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springsecurity.demo.dao.PurchaseBillVoucherDao;
import com.luv2code.springsecurity.demo.entity.PurchaseBillVoucher;
@Service
public class PurchaseBillVoucherServiceImpl implements PurchaseBillVoucherService {
    @Autowired
    private PurchaseBillVoucherDao purchaseBillVoucherDao;

    @Override
    public PurchaseBillVoucher getPurchaseBillVoucher(Long id) {
        // TODO Auto-generated method stub
        return purchaseBillVoucherDao.getPurchaseBillVoucher(id);
    }

    @Override
    public List<PurchaseBillVoucher> getPurchaseBillVoucher(Long accountId, String userName) {
        // TODO Auto-generated method stub
        return purchaseBillVoucherDao.getPurchaseBillVoucher(accountId, userName);
    }

    @Override
    public void save(PurchaseBillVoucher toSave) {
        // TODO Auto-generated method stub
        purchaseBillVoucherDao.save(toSave);
    }

    @Override
    public List<PurchaseBillVoucher> getPurchaseBillVoucherByAccountId(Long id) {
        // TODO Auto-generated method stub
        return purchaseBillVoucherDao.getPurchaseBillVoucherByAccountId(id);
    }

    @Override
    public List<PurchaseBillVoucher> getPurchaseBillVoucherByDate(Date curDate, String userName) {
        // TODO Auto-generated method stub
        return purchaseBillVoucherDao.getPurchaseBillVoucherByDate(curDate, userName);
    }

    @Override
    public List<PurchaseBillVoucher> getPurchaseBillVoucherByUserName(String userName) {
        // TODO Auto-generated method stub
        return purchaseBillVoucherDao.getPurchaseBillVoucherByUserName(userName);
    }

    @Override
    public List<PurchaseBillVoucher> getPurchaseBillVoucherBetweenDates(Date curDate, Date endDate, String userName) {
        // TODO Auto-generated method stub
        return purchaseBillVoucherDao.getPurchaseBillVoucherBetweenDates(curDate, endDate, userName);
    }

}
