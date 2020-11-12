package com.luv2code.springsecurity.demo.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springsecurity.demo.entity.PurchaseBillVoucher;
@Repository
public class PurchaseBillVoucherDaoImpl implements PurchaseBillVoucherDao {
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    @Transactional
    public PurchaseBillVoucher getPurchaseBillVoucher(Long id) {
        // TODO Auto-generated method stub
        Session crs = sessionFactory.getCurrentSession();
        PurchaseBillVoucher item = crs.get(PurchaseBillVoucher.class, id);
        return item;
    }

    @Override
    @Transactional
    public List<PurchaseBillVoucher> getPurchaseBillVoucher(Long accountId, String userName) {
        // TODO Auto-generated method stub
        Session crs = sessionFactory.getCurrentSession();
        Query<PurchaseBillVoucher> theQuery = crs.createQuery("from PurchaseBillVoucher where "
                + "accountId=:AccountId and "
                + "userName =: UserName order by date DESC", PurchaseBillVoucher.class);
        theQuery.setParameter("AccountId", accountId);
        theQuery.setParameter("UserName", userName);
        List<PurchaseBillVoucher> toReturn = theQuery.getResultList();
        return toReturn;
    }

    @Override
    @Transactional
    public void save(PurchaseBillVoucher toSave) {
        // TODO Auto-generated method stub
        Session crs = sessionFactory.getCurrentSession();
        crs.saveOrUpdate(toSave);
        
    }

    @Override
    @Transactional
    public List<PurchaseBillVoucher> getPurchaseBillVoucherByAccountId(Long id) {
        // TODO Auto-generated method stub
        Session crs = sessionFactory.getCurrentSession();
        Query<PurchaseBillVoucher> theQuery = crs.createQuery("from PurchaseBillVoucher where "
                + "accountId=:AccountId order by date DESC"
                , PurchaseBillVoucher.class);
        theQuery.setParameter("AccountId", id);
        List<PurchaseBillVoucher> toReturn = theQuery.getResultList();
        return toReturn;
    }

    @Override
    @Transactional
    public List<PurchaseBillVoucher> getPurchaseBillVoucherByDate(Date curDate, String userName) {
        // TODO Auto-generated method stub
        Session crs = sessionFactory.getCurrentSession();
        Query<PurchaseBillVoucher> theQuery = crs.createQuery("from PurchaseBillVoucher where "
                + "date >= :curDate and "
                + "userName =: UserName order by date DESC", PurchaseBillVoucher.class);
        theQuery.setParameter("curDate", curDate);
        theQuery.setParameter("UserName", userName);
        List<PurchaseBillVoucher> toReturn = theQuery.getResultList();
        return toReturn;
    }

    @Override
    @Transactional
    public List<PurchaseBillVoucher> getPurchaseBillVoucherByUserName(String userName) {
        // TODO Auto-generated method stub
        Session crs = sessionFactory.getCurrentSession();
        Query<PurchaseBillVoucher> theQuery = crs.createQuery("from PurchaseBillVoucher where "
                + "userName =: UserName order by date DESC", PurchaseBillVoucher.class);
        theQuery.setParameter("UserName", userName);
        List<PurchaseBillVoucher> toReturn = theQuery.getResultList();
        return toReturn;
    }


    @Override
    @Transactional
    public List<PurchaseBillVoucher> getPurchaseBillVoucherBetweenDates(Date curDate, Date endDate, String userName) {
        // TODO Auto-generated method stub
        Session crs = sessionFactory.getCurrentSession();
        Query<PurchaseBillVoucher> theQuery = crs.createQuery("from PurchaseBillVoucher where "
                + "date >= :curDate and "
                + "userName =: UserName "
                + "and date <= :endDate order by date DESC", PurchaseBillVoucher.class);
        theQuery.setParameter("curDate", curDate);
        theQuery.setParameter("endDate", curDate);
        theQuery.setParameter("UserName", userName);
        List<PurchaseBillVoucher> toReturn = theQuery.getResultList();
        return toReturn;
    }

}
