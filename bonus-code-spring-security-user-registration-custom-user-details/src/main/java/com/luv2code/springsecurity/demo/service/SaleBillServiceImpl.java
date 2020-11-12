package com.luv2code.springsecurity.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springsecurity.demo.dao.SaleBillDao;
import com.luv2code.springsecurity.demo.entity.SaleBill;
@Service
public class SaleBillServiceImpl implements SaleBillService {
    @Autowired
    private SaleBillDao saleBillDao;

    @Override
    public SaleBill getSaleBill(Long id) {
        // TODO Auto-generated method stub
        return saleBillDao.getSaleBill(id);
    }

    @Override
    public List<SaleBill> getSaleBill(Long accountId, String userName) {
        // TODO Auto-generated method stub
        return saleBillDao.getSaleBill(accountId, userName);
    }

    @Override
    public void save(SaleBill toSave) {
        // TODO Auto-generated method stub
        saleBillDao.save(toSave);
    }

    @Override
    public List<SaleBill> getSaleBillByAccountId(Long id) {
        // TODO Auto-generated method stub
        return saleBillDao.getSaleBillByAccountId(id);
    }

    @Override
    public List<SaleBill> getSaleBillByDate(Date curDate, String userName) {
        // TODO Auto-generated method stub
        return saleBillDao.getSaleBillByDate(curDate, userName);
    }

    @Override
    public List<SaleBill> getSaleBillByUserName(String userName) {
        // TODO Auto-generated method stub
        return saleBillDao.getSaleBillByUserName(userName);
    }

    @Override
    public List<SaleBill> getSaleBillBetweenDates(Date curDate, Date endDate, String userName) {
        // TODO Auto-generated method stub
        return saleBillDao.getSaleBillBetweenDates(curDate, endDate, userName);
    }

}
