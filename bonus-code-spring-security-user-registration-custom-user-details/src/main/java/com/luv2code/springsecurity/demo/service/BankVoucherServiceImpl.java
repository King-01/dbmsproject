package com.luv2code.springsecurity.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springsecurity.demo.dao.BankVoucherDao;
import com.luv2code.springsecurity.demo.entity.BankVoucher;
@Service
public class BankVoucherServiceImpl implements BankVoucherService {
    @Autowired
    private BankVoucherDao bankVoucherDao;

    @Override
    public BankVoucher getBankVoucher(Long id) {
        // TODO Auto-generated method stub
        return bankVoucherDao.getBankVoucher(id);
    }

    @Override
    public List<BankVoucher> getBankVoucher(Long accountId, String userName) {
        // TODO Auto-generated method stub
        return bankVoucherDao.getBankVoucher(accountId, userName);
    }

    @Override
    public void save(BankVoucher toSave) {
        // TODO Auto-generated method stub
        bankVoucherDao.save(toSave);
    }

    @Override
    public List<BankVoucher> getBankVoucherByAccountId(Long id) {
        // TODO Auto-generated method stub
        return bankVoucherDao.getBankVoucherByAccountId(id);
    }

    @Override
    public List<BankVoucher> getBankVoucherByDate(Date curDate, String userName) {
        // TODO Auto-generated method stub
        return bankVoucherDao.getBankVoucherByDate(curDate, userName);
    }

    @Override
    public List<BankVoucher> getBankVoucherByUserName(String userName) {
        // TODO Auto-generated method stub
        return bankVoucherDao.getBankVoucherByUserName(userName);
    }

    @Override
    public List<BankVoucher> getBankVoucherBetweenDates(Date curDate, Date endDate, String userName) {
        // TODO Auto-generated method stub
        return bankVoucherDao.getBankVoucherBetweenDates(curDate, endDate, userName);
    }

}
