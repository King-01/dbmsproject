package com.luv2code.springsecurity.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springsecurity.demo.entity.StockTax;
import com.luv2code.springsecurity.demo.entity.Tax;
import com.luv2code.springsecurity.demo.service.TaxService;
import com.luv2code.springsecurity.demo.service.UserService;
@Repository
public class TaxDaoImpl implements TaxDao {
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private UserService userService;
	@Override
	@Transactional
	public Tax getTax(String theName, String userName) {
		// TODO Auto-generated method stub
		Long userId = userService.findByUserName(userName).getId();
		Session crs = sessionFactory.getCurrentSession();
		Query<Tax> theQuery = crs.createQuery("from Tax where taxName=:theName"
				+ " and userid=:userId", Tax.class);
		theQuery.setParameter("taxName", theName);
		theQuery.setParameter("userId", userId);
		return theQuery.getSingleResult();
	}
	@Override
	@Transactional
	public void save(Tax toSave) {
		// TODO Auto-generated method stub
		Session crs = sessionFactory.getCurrentSession();
		crs.saveOrUpdate(toSave);
	}
	@Override
	@Transactional
	public List<Tax> getTaxByUserName(String userName) {
		// TODO Auto-generated method stub
		Long userId = userService.findByUserName(userName).getId();
		Session crs = sessionFactory.getCurrentSession();

		Query<Tax> theQuery = crs.createQuery("from Tax where"
				+ " userid=:userId", Tax.class);
		theQuery.setParameter("userId", userId);
		return theQuery.getResultList();
	}	

	
	

}
