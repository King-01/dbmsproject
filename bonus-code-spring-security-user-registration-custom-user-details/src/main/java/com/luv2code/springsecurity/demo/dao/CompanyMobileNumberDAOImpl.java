package com.luv2code.springsecurity.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springsecurity.demo.entity.CompanyMobileNumber;
@Repository
public class CompanyMobileNumberDAOImpl implements CompanyMobileNumberDAO {

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<CompanyMobileNumber> getMobileNumber(String userName) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		Query<CompanyMobileNumber> theQuery = 
				currentSession.createQuery("from CompanyMobileNumber where username_id =: userName",
						CompanyMobileNumber.class);
		theQuery.setParameter("userName", userName);
		List<CompanyMobileNumber> toReturn = theQuery.getResultList();
		return toReturn;
	}

	@Override
	public CompanyMobileNumber getMobileNumber(int theId) {
		// TODO Auto-generated method stub
		Session crs = sessionFactory.getCurrentSession();
		CompanyMobileNumber toRet = crs.get(CompanyMobileNumber.class, theId);
		return toRet;
	}

	@Override
	public void saveMobileNumber(CompanyMobileNumber theCompanyMobileNumber) {
		// TODO Auto-generated method stub
		Session crs = sessionFactory.getCurrentSession();
		crs.saveOrUpdate(theCompanyMobileNumber);
	}

	@Override
	public void deleteMobileNumber(int theId) {
		// TODO Auto-generated method stub
		Session crs = sessionFactory.getCurrentSession();
		CompanyMobileNumber toDelete = crs.get(CompanyMobileNumber.class, theId);
		crs.delete(toDelete);
	}

}
