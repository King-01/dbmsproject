package com.luv2code.springsecurity.demo.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springsecurity.demo.entity.CashVoucher;
@Repository
public class CashVoucherDaoImpl implements CashVoucherDao {
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    @Transactional
    public CashVoucher getCashVoucher(Long id) {
        // TODO Auto-generated method stub
        Session crs = sessionFactory.getCurrentSession();
        CashVoucher item = crs.get(CashVoucher.class, id);
        return item;
    }

    @Override
    @Transactional
    public List<CashVoucher> getCashVoucher(Long accountId, String userName) {
        // TODO Auto-generated method stub
        Session crs = sessionFactory.getCurrentSession();
        Query<CashVoucher> theQuery = crs.createQuery("from CashVoucher where "
                + "accountId=:AccountId and "
                + "userName =: UserName order by date DESC", CashVoucher.class);
        theQuery.setParameter("AccountId", accountId);
        theQuery.setParameter("UserName", userName);
        List<CashVoucher> toReturn = theQuery.getResultList();
        return toReturn;
    }

    @Override
    @Transactional
    public void save(CashVoucher toSave) {
        // TODO Auto-generated method stub
        Session crs = sessionFactory.getCurrentSession();
        crs.saveOrUpdate(toSave);
        
    }

    @Override
    @Transactional
    public List<CashVoucher> getCashVoucherByAccountId(Long id) {
        // TODO Auto-generated method stub
        Session crs = sessionFactory.getCurrentSession();
        Query<CashVoucher> theQuery = crs.createQuery("from CashVoucher where "
                + "accountId=:AccountId order by date DESC"
                , CashVoucher.class);
        theQuery.setParameter("AccountId", id);
        List<CashVoucher> toReturn = theQuery.getResultList();
        return toReturn;
    }

    @Override
    @Transactional
    public List<CashVoucher> getCashVoucherByDate(Date curDate, String userName) {
        // TODO Auto-generated method stub
        Session crs = sessionFactory.getCurrentSession();
        Query<CashVoucher> theQuery = crs.createQuery("from CashVoucher where "
                + "date >= :curDate and "
                + "userName =: UserName order by date DESC", CashVoucher.class);
        theQuery.setParameter("curDate", curDate);
        theQuery.setParameter("UserName", userName);
        List<CashVoucher> toReturn = theQuery.getResultList();
        return toReturn;
    }

    @Override
    @Transactional
    public List<CashVoucher> getCashVoucherByUserName(String userName) {
        // TODO Auto-generated method stub
        Session crs = sessionFactory.getCurrentSession();
        Query<CashVoucher> theQuery = crs.createQuery("from CashVoucher where "
                + "userName =: UserName order by date DESC", CashVoucher.class);
        theQuery.setParameter("UserName", userName);
        List<CashVoucher> toReturn = theQuery.getResultList();
        return toReturn;
    }


    @Override
    @Transactional
    public List<CashVoucher> getCashVoucherBetweenDates(Date curDate, Date endDate, String userName) {
        // TODO Auto-generated method stub
        Session crs = sessionFactory.getCurrentSession();
        Query<CashVoucher> theQuery = crs.createQuery("from CashVoucher where "
                + "date >= :curDate and "
                + "userName =: UserName "
                + "and date <= :endDate order by date DESC", CashVoucher.class);
        theQuery.setParameter("curDate", curDate);
        theQuery.setParameter("endDate", curDate);
        theQuery.setParameter("UserName", userName);
        List<CashVoucher> toReturn = theQuery.getResultList();
        return toReturn;
    }

}
