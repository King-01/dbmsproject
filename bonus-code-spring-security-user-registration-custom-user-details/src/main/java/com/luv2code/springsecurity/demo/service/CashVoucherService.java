package com.luv2code.springsecurity.demo.service;

import java.util.Date;
import java.util.List;

import com.luv2code.springsecurity.demo.entity.CashVoucher;

public interface CashVoucherService {
    CashVoucher getCashVoucher(Long id);
    List<CashVoucher> getCashVoucher(Long accountId, String userName);
    
    void save(CashVoucher toSave);
    List<CashVoucher> getCashVoucherByAccountId(Long id);
    List<CashVoucher> getCashVoucherByDate(Date curDate, String userName);
    List<CashVoucher> getCashVoucherByUserName(String userName);
    List<CashVoucher> getCashVoucherBetweenDates(Date curDate, Date endDate, String userName);
}
