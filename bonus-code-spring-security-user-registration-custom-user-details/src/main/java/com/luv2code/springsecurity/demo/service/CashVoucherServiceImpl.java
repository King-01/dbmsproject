package com.luv2code.springsecurity.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springsecurity.demo.dao.CashVoucherDao;
import com.luv2code.springsecurity.demo.entity.CashVoucher;
@Service
public class CashVoucherServiceImpl implements CashVoucherService {
    @Autowired
    private CashVoucherDao bankVoucherDao;

    @Override
    public CashVoucher getCashVoucher(Long id) {
        // TODO Auto-generated method stub
        return bankVoucherDao.getCashVoucher(id);
    }

    @Override
    public List<CashVoucher> getCashVoucher(Long accountId, String userName) {
        // TODO Auto-generated method stub
        return bankVoucherDao.getCashVoucher(accountId, userName);
    }

    @Override
    public void save(CashVoucher toSave) {
        // TODO Auto-generated method stub
        bankVoucherDao.save(toSave);
    }

    @Override
    public List<CashVoucher> getCashVoucherByAccountId(Long id) {
        // TODO Auto-generated method stub
        return bankVoucherDao.getCashVoucherByAccountId(id);
    }

    @Override
    public List<CashVoucher> getCashVoucherByDate(Date curDate, String userName) {
        // TODO Auto-generated method stub
        return bankVoucherDao.getCashVoucherByDate(curDate, userName);
    }

    @Override
    public List<CashVoucher> getCashVoucherByUserName(String userName) {
        // TODO Auto-generated method stub
        return bankVoucherDao.getCashVoucherByUserName(userName);
    }

    @Override
    public List<CashVoucher> getCashVoucherBetweenDates(Date curDate, Date endDate, String userName) {
        // TODO Auto-generated method stub
        return bankVoucherDao.getCashVoucherBetweenDates(curDate, endDate, userName);
    }

}
