package com.luv2code.springsecurity.demo.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springsecurity.demo.entity.BankVoucher;
@Repository
public class BankVoucherDaoImpl implements BankVoucherDao {
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    @Transactional
    public BankVoucher getBankVoucher(Long id) {
        // TODO Auto-generated method stub
        Session crs = sessionFactory.getCurrentSession();
        BankVoucher item = crs.get(BankVoucher.class, id);
        return item;
    }

    @Override
    @Transactional
    public List<BankVoucher> getBankVoucher(Long accountId, String userName) {
        // TODO Auto-generated method stub
        Session crs = sessionFactory.getCurrentSession();
        Query<BankVoucher> theQuery = crs.createQuery("from BankVoucher where "
                + "accountId=:AccountId and "
                + "userName =: UserName order by date DESC", BankVoucher.class);
        theQuery.setParameter("AccountId", accountId);
        theQuery.setParameter("UserName", userName);
        List<BankVoucher> toReturn = theQuery.getResultList();
        return toReturn;
    }

    @Override
    @Transactional
    public void save(BankVoucher toSave) {
        // TODO Auto-generated method stub
        Session crs = sessionFactory.getCurrentSession();
        crs.saveOrUpdate(toSave);
        
    }

    @Override
    @Transactional
    public List<BankVoucher> getBankVoucherByAccountId(Long id) {
        // TODO Auto-generated method stub
        Session crs = sessionFactory.getCurrentSession();
        Query<BankVoucher> theQuery = crs.createQuery("from BankVoucher where "
                + "accountId=:AccountId order by date DESC"
                , BankVoucher.class);
        theQuery.setParameter("AccountId", id);
        List<BankVoucher> toReturn = theQuery.getResultList();
        return toReturn;
    }

    @Override
    @Transactional
    public List<BankVoucher> getBankVoucherByDate(Date curDate, String userName) {
        // TODO Auto-generated method stub
        Session crs = sessionFactory.getCurrentSession();
        Query<BankVoucher> theQuery = crs.createQuery("from BankVoucher where "
                + "date >= :curDate and "
                + "userName =: UserName order by date DESC", BankVoucher.class);
        theQuery.setParameter("curDate", curDate);
        theQuery.setParameter("UserName", userName);
        List<BankVoucher> toReturn = theQuery.getResultList();
        return toReturn;
    }

    @Override
    @Transactional
    public List<BankVoucher> getBankVoucherByUserName(String userName) {
        // TODO Auto-generated method stub
        Session crs = sessionFactory.getCurrentSession();
        Query<BankVoucher> theQuery = crs.createQuery("from BankVoucher where "
                + "userName =: UserName order by date DESC", BankVoucher.class);
        theQuery.setParameter("UserName", userName);
        List<BankVoucher> toReturn = theQuery.getResultList();
        return toReturn;
    }


    @Override
    @Transactional
    public List<BankVoucher> getBankVoucherBetweenDates(Date curDate, Date endDate, String userName) {
        // TODO Auto-generated method stub
        Session crs = sessionFactory.getCurrentSession();
        Query<BankVoucher> theQuery = crs.createQuery("from BankVoucher where "
                + "date >= :curDate and "
                + "userName =: UserName "
                + "and date <= :endDate order by date DESC", BankVoucher.class);
        theQuery.setParameter("curDate", curDate);
        theQuery.setParameter("endDate", curDate);
        theQuery.setParameter("UserName", userName);
        List<BankVoucher> toReturn = theQuery.getResultList();
        return toReturn;
    }

}
