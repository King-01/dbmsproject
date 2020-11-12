package com.luv2code.springsecurity.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springsecurity.demo.entity.PurchaseBillTransactions;
@Repository
public class PurchaseBillVoucherTransactionsDaoImpl implements PurchaseBillVoucherTransactionsDao {
    @Autowired
    private SessionFactory sessionFactory;
    

    @Override
    @Transactional
    public void save(PurchaseBillTransactions toSave) {
        // TODO Auto-generated method stub
        Session crs = sessionFactory.getCurrentSession();
        crs.saveOrUpdate(toSave);
        
    }

	@Override
    @Transactional
	public PurchaseBillTransactions getPurchaseBillVoucherTransactionsById(Long id) {
		// TODO Auto-generated method stub
        Session crs = sessionFactory.getCurrentSession();
		return crs.get(PurchaseBillTransactions.class, id);
	}

	@Override
    @Transactional
	public List<PurchaseBillTransactions> getPurchaseBillVoucherTransactions(Long pvoucherid) {
		// TODO Auto-generated method stub
        Session crs = sessionFactory.getCurrentSession();
        Query<PurchaseBillTransactions> theQuery = crs.createQuery("from PurchaseBillVoucher where "
                + "pvoucherid=:Pvoucherid", PurchaseBillTransactions.class);
		theQuery.setParameter("Pvoucherid", pvoucherid);
        return theQuery.getResultList();
	}

}
