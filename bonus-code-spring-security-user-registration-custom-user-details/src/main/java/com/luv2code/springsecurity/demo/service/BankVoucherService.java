package com.luv2code.springsecurity.demo.service;

import java.util.Date;
import java.util.List;

import com.luv2code.springsecurity.demo.entity.BankVoucher;

public interface BankVoucherService {
    BankVoucher getBankVoucher(Long id);
    List<BankVoucher> getBankVoucher(Long accountId, String userName);
    
    void save(BankVoucher toSave);
    List<BankVoucher> getBankVoucherByAccountId(Long id);
    List<BankVoucher> getBankVoucherByDate(Date curDate, String userName);
    List<BankVoucher> getBankVoucherByUserName(String userName);
    List<BankVoucher> getBankVoucherBetweenDates(Date curDate, Date endDate, String userName);
}
