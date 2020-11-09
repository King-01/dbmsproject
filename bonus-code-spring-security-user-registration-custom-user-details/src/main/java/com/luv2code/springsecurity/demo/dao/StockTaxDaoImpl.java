package com.luv2code.springsecurity.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springsecurity.demo.entity.StockTax;
import com.luv2code.springsecurity.demo.entity.Tax;
import com.luv2code.springsecurity.demo.service.TaxService;
@Repository
public class StockTaxDaoImpl implements StockTaxDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private TaxService taxService;
	private Logger logger = Logger.getLogger(getClass().getName());
	@Override
	@Transactional
	public void save(StockTax toSave) {
		// TODO Auto-generated method stub
		Session crs = sessionFactory.getCurrentSession();
		crs.saveOrUpdate(toSave);
		
	}
	@Override
	@Transactional
	public List<StockTax> getStockTaxByStockId(Long theId) {
		// TODO Auto-generated method stub
		Session crs = sessionFactory.getCurrentSession();
		Query<StockTax> theQuery = crs.createQuery("from StockTax where"
				+ " stockId=:StockId", StockTax.class);
		theQuery.setParameter("StockId", theId);
		return theQuery.getResultList();	
	}
	@Override
	@Transactional
	public List<StockTax> getStockTaxByTaxId(Long theId) {
		// TODO Auto-generated method stubSession 
		Session crs = sessionFactory.getCurrentSession();
		Query<StockTax> theQuery = crs.createQuery("from StockTax where"
				+ " taxId=:TaxId", StockTax.class);
		theQuery.setParameter("TaxId", theId);
		return theQuery.getResultList();
	}
	@Override
	@Transactional
	public List<StockTax> getStockTaxByUserName(String userName) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		List<Tax> theList = taxService.getTaxByUserName(userName);
		logger.info(Integer.toString(theList.size()));
		List<StockTax> toRet = new ArrayList<StockTax>();
		for(int i = 0; i < theList.size(); i++) {
			Session crs = sessionFactory.getCurrentSession();
			Query<StockTax> theQuery = crs.createQuery("from StockTax where"
					+ " taxId=:TaxId", StockTax.class);
			theQuery.setParameter("TaxId", theList.get(i).getId());
			List<StockTax> tempList = theQuery.getResultList();
			logger.info(Integer.toString(tempList.size()));
			for(int j = 0; j < tempList.size(); i++)
			{
				toRet.add(tempList.get(j));
			}
		}
		return toRet;
	}
	@Override
	@Transactional
	public StockTax getStockTax(Long stId, Long tId) {
		// TODO Auto-generated method stub

		Session crs = sessionFactory.getCurrentSession();
		Query<StockTax> theQuery = crs
				.createQuery("from StockTax where stockId=:StockId"
				+ " and taxId=:TaxId", StockTax.class);
		theQuery.setParameter("TaxId", tId);
		theQuery.setParameter("StockId", stId);
		return theQuery.getSingleResult();
	}
	@Override
	@Transactional
	public List<StockTax> getTaxByStockId(Long theId) {
		// TODO Auto-generated method stub
		Session crs = sessionFactory.getCurrentSession();
		Query<StockTax> theQuery = crs
				.createQuery("from StockTax where stockId=:StockId"
				, StockTax.class);
		theQuery.setParameter("StockId", theId);
		return theQuery.getResultList();
		
	}
	@Override
	@Transactional
	public List<StockTax> getStockItemByTaxId(Long theId) {
		// TODO Auto-generated method stub
		Session crs = sessionFactory.getCurrentSession();
		Query<StockTax> theQuery = crs
				.createQuery("from StockTax where taxId=:StockId"
				, StockTax.class);
		theQuery.setParameter("StockId", theId);
		return theQuery.getResultList();
		
	}

	

	
	

}
