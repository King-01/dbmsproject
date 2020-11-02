package com.luv2code.springsecurity.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springsecurity.demo.entity.CompanyEmail;
@Repository
public class CompanyEmailDAOImpl implements CompanyEmailDAO {
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<CompanyEmail> getEmail(String userName) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		Query<CompanyEmail> theQuery = 
				currentSession.createQuery("from CompanyEmail where username_id=:userName",
						CompanyEmail.class);
		theQuery.setParameter("userName", userName);
		List<CompanyEmail> companyEmails = theQuery.getResultList();
		return companyEmails;
	}

	@Override
	public CompanyEmail getEmail(int theId) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		CompanyEmail theCompanyEmail = new CompanyEmail();
		theCompanyEmail = currentSession.get(CompanyEmail.class, theId);
		return theCompanyEmail;
	}

	@Override
	public void saveEmail(CompanyEmail theCompanyEmail) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theCompanyEmail);
	}

	@Override
	public void deleteEmail(int theId) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();;
		CompanyEmail theCompanyEmail = currentSession.get(CompanyEmail.class, theId);
		currentSession.delete(theCompanyEmail);
	}

}
