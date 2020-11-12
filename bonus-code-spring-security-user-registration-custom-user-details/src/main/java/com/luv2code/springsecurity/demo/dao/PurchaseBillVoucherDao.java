package com.luv2code.springsecurity.demo.dao;

import java.util.Date;
import java.util.List;

import com.luv2code.springsecurity.demo.entity.PurchaseBillVoucher;

public interface PurchaseBillVoucherDao {
    PurchaseBillVoucher getPurchaseBillVoucher(Long id);
    List<PurchaseBillVoucher> getPurchaseBillVoucher(Long accountId, String userName);
    
    void save(PurchaseBillVoucher toSave);
    List<PurchaseBillVoucher> getPurchaseBillVoucherByAccountId(Long id);
    List<PurchaseBillVoucher> getPurchaseBillVoucherByDate(Date curDate, String userName);
    List<PurchaseBillVoucher> getPurchaseBillVoucherByUserName(String userName);
    List<PurchaseBillVoucher> getPurchaseBillVoucherBetweenDates(Date curDate, Date endDate, String userName);

}
