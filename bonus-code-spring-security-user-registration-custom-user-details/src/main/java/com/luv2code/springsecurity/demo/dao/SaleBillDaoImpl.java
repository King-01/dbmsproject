package com.luv2code.springsecurity.demo.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springsecurity.demo.entity.SaleBill;
@Repository
public class SaleBillDaoImpl implements SaleBillDao {
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    @Transactional
    public SaleBill getSaleBill(Long id) {
        // TODO Auto-generated method stub
        Session crs = sessionFactory.getCurrentSession();
        SaleBill item = crs.get(SaleBill.class, id);
        return item;
    }

    @Override
    @Transactional
    public List<SaleBill> getSaleBill(Long accountId, String userName) {
        // TODO Auto-generated method stub
        Session crs = sessionFactory.getCurrentSession();
        Query<SaleBill> theQuery = crs.createQuery("from SaleBill where "
                + "accountId=:AccountId and "
                + "userName =: UserName order by date DESC", SaleBill.class);
        theQuery.setParameter("AccountId", accountId);
        theQuery.setParameter("UserName", userName);
        List<SaleBill> toReturn = theQuery.getResultList();
        return toReturn;
    }

    @Override
    @Transactional
    public void save(SaleBill toSave) {
        // TODO Auto-generated method stub
        Session crs = sessionFactory.getCurrentSession();
        crs.saveOrUpdate(toSave);
        
    }

    @Override
    @Transactional
    public List<SaleBill> getSaleBillByAccountId(Long id) {
        // TODO Auto-generated method stub
        Session crs = sessionFactory.getCurrentSession();
        Query<SaleBill> theQuery = crs.createQuery("from SaleBill where "
                + "accountId=:AccountId order by date DESC"
                , SaleBill.class);
        theQuery.setParameter("AccountId", id);
        List<SaleBill> toReturn = theQuery.getResultList();
        return toReturn;
    }

    @Override
    @Transactional
    public List<SaleBill> getSaleBillByDate(Date curDate, String userName) {
        // TODO Auto-generated method stub
        Session crs = sessionFactory.getCurrentSession();
        Query<SaleBill> theQuery = crs.createQuery("from SaleBill where "
                + "date >= :curDate and "
                + "userName =: UserName order by date DESC", SaleBill.class);
        theQuery.setParameter("curDate", curDate);
        theQuery.setParameter("UserName", userName);
        List<SaleBill> toReturn = theQuery.getResultList();
        return toReturn;
    }

    @Override
    @Transactional
    public List<SaleBill> getSaleBillByUserName(String userName) {
        // TODO Auto-generated method stub
        Session crs = sessionFactory.getCurrentSession();
        Query<SaleBill> theQuery = crs.createQuery("from SaleBill where "
                + "userName =: UserName order by date DESC", SaleBill.class);
        theQuery.setParameter("UserName", userName);
        List<SaleBill> toReturn = theQuery.getResultList();
        return toReturn;
    }


    @Override
    @Transactional
    public List<SaleBill> getSaleBillBetweenDates(Date curDate, Date endDate, String userName) {
        // TODO Auto-generated method stub
        Session crs = sessionFactory.getCurrentSession();
        Query<SaleBill> theQuery = crs.createQuery("from SaleBill where "
                + "date >= :curDate and "
                + "userName =: UserName "
                + "and date <= :endDate order by date DESC", SaleBill.class);
        theQuery.setParameter("curDate", curDate);
        theQuery.setParameter("endDate", curDate);
        theQuery.setParameter("UserName", userName);
        List<SaleBill> toReturn = theQuery.getResultList();
        return toReturn;
    }

}
