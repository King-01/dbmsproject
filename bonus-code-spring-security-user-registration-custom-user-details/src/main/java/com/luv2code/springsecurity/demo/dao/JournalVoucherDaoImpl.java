package com.luv2code.springsecurity.demo.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springsecurity.demo.entity.JournalVoucher;
@Repository
public class JournalVoucherDaoImpl implements JournalVoucherDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public JournalVoucher getJournalVoucher(Long id) {
		// TODO Auto-generated method stub
		Session crs = sessionFactory.getCurrentSession();
		JournalVoucher item = crs.get(JournalVoucher.class, id);
		return item;
	}

	@Override
	@Transactional
	public List<JournalVoucher> getJournalVoucher(Long accountId, String userName) {
		// TODO Auto-generated method stub
		Session crs = sessionFactory.getCurrentSession();
		Query<JournalVoucher> theQuery = crs.createQuery("from JournalVoucher where "
				+ "accountId=:AccountId and "
				+ "userName =: UserName order by date DESC", JournalVoucher.class);
		theQuery.setParameter("AccountId", accountId);
		theQuery.setParameter("UserName", userName);
		List<JournalVoucher> toReturn = theQuery.getResultList();
		return toReturn;
	}

	@Override
	@Transactional
	public void save(JournalVoucher toSave) {
		// TODO Auto-generated method stub
		Session crs = sessionFactory.getCurrentSession();
		crs.saveOrUpdate(toSave);
		
	}

	@Override
	@Transactional
	public List<JournalVoucher> getJournalVoucherByAccountId(Long id) {
		// TODO Auto-generated method stub
		Session crs = sessionFactory.getCurrentSession();
		Query<JournalVoucher> theQuery = crs.createQuery("from JournalVoucher where "
				+ "accountId=:AccountId order by date DESC"
				, JournalVoucher.class);
		theQuery.setParameter("AccountId", id);
		List<JournalVoucher> toReturn = theQuery.getResultList();
		return toReturn;
	}

	@Override
	@Transactional
	public List<JournalVoucher> getJournalVoucherByDate(Date curDate, String userName) {
		// TODO Auto-generated method stub
		Session crs = sessionFactory.getCurrentSession();
		Query<JournalVoucher> theQuery = crs.createQuery("from JournalVoucher where "
				+ "date >= :curDate and "
				+ "userName =: UserName order by date DESC", JournalVoucher.class);
		theQuery.setParameter("curDate", curDate);
		theQuery.setParameter("UserName", userName);
		List<JournalVoucher> toReturn = theQuery.getResultList();
		return toReturn;
	}

	@Override
	@Transactional
	public List<JournalVoucher> getJournalVoucherByUserName(String userName) {
		// TODO Auto-generated method stub
		Session crs = sessionFactory.getCurrentSession();
		Query<JournalVoucher> theQuery = crs.createQuery("from JournalVoucher where "
				+ "userName =: UserName order by date DESC", JournalVoucher.class);
		theQuery.setParameter("UserName", userName);
		List<JournalVoucher> toReturn = theQuery.getResultList();
		return toReturn;
	}


	@Override
	@Transactional
	public List<JournalVoucher> getJournalVoucherBetweenDates(Date curDate, Date endDate, String userName) {
		// TODO Auto-generated method stub
		Session crs = sessionFactory.getCurrentSession();
		Query<JournalVoucher> theQuery = crs.createQuery("from JournalVoucher where "
				+ "date >= :curDate and "
				+ "userName =: UserName "
				+ "and date <= :endDate order by date DESC", JournalVoucher.class);
		theQuery.setParameter("curDate", curDate);
		theQuery.setParameter("endDate", curDate);
		theQuery.setParameter("UserName", userName);
		List<JournalVoucher> toReturn = theQuery.getResultList();
		return toReturn;
	}

}
