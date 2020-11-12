package com.luv2code.springsecurity.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springsecurity.demo.entity.SaleBillTransactions;
@Repository
public class SaleBillTransactionsDaoImpl implements SaleBillTransactionsDao {
    @Autowired
    private SessionFactory sessionFactory;
    

    @Override
    @Transactional
    public void save(SaleBillTransactions toSave) {
        // TODO Auto-generated method stub
        Session crs = sessionFactory.getCurrentSession();
        crs.saveOrUpdate(toSave);
        
    }

    @Override
    @Transactional
    public SaleBillTransactions getSaleBillTransactionsById(Long id) {
        // TODO Auto-generated method stub
        Session crs = sessionFactory.getCurrentSession();
        return crs.get(SaleBillTransactions.class, id);
    }

    @Override
    @Transactional
    public List<SaleBillTransactions> getSaleBillTransactions(Long svoucherid) {
        // TODO Auto-generated method stub
        Session crs = sessionFactory.getCurrentSession();
        Query<SaleBillTransactions> theQuery = crs.createQuery("from PurchaseBillVoucher where "
                + "svoucherid=:Svoucherid", SaleBillTransactions.class);
        theQuery.setParameter("Svoucherid", svoucherid);
        return theQuery.getResultList();
    }

}
