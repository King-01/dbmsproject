package com.luv2code.springsecurity.demo.service;

import java.util.Date;
import java.util.List;

import com.luv2code.springsecurity.demo.entity.SaleBill;

public interface SaleBillService {
    SaleBill getSaleBill(Long id);
    List<SaleBill> getSaleBill(Long accountId, String userName);
    
    void save(SaleBill toSave);
    List<SaleBill> getSaleBillByAccountId(Long id);
    List<SaleBill> getSaleBillByDate(Date curDate, String userName);
    List<SaleBill> getSaleBillByUserName(String userName);
    List<SaleBill> getSaleBillBetweenDates(Date curDate, Date endDate, String userName);
}
