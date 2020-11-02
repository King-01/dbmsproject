package com.luv2code.springsecurity.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springsecurity.demo.dao.CompanyEmailDAO;
import com.luv2code.springsecurity.demo.entity.CompanyEmail;
@Service
public class CompanyEmailServiceImp implements CompanyEmailService {
	@Autowired
	CompanyEmailDAO companyEmailDAO;
	@Override
	@Transactional
	public List<CompanyEmail> getEmail(String userName) {
		// TODO Auto-generated method stub
		return companyEmailDAO.getEmail(userName);
	}

	@Override
	@Transactional
	public CompanyEmail getEmail(int theId) {
		// TODO Auto-generated method stub
		return companyEmailDAO.getEmail(theId);
	}

	@Override
	@Transactional
	public void saveEmail(CompanyEmail theCompanyEmail) {
		// TODO Auto-generated method stub
		companyEmailDAO.saveEmail(theCompanyEmail);

	}

	@Override
	@Transactional
	public void deleteEmail(int theId) {
		// TODO Auto-generated method stub
		companyEmailDAO.deleteEmail(theId);

	}

}
