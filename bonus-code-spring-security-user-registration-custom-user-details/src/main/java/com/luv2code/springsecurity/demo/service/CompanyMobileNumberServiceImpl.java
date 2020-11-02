package com.luv2code.springsecurity.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springsecurity.demo.dao.CompanyMobileNumberDAO;
import com.luv2code.springsecurity.demo.entity.CompanyMobileNumber;
@Service
public class CompanyMobileNumberServiceImpl implements CompanyMobileNumberService {
	@Autowired
	CompanyMobileNumberDAO companyMobileNumberDAO;
	@Override
	@Transactional
	public List<CompanyMobileNumber> getMobileNumber(String userName) {
		// TODO Auto-generated method stub
		return companyMobileNumberDAO.getMobileNumber(userName);
	}

	@Override
	@Transactional
	public CompanyMobileNumber getMobileNumber(int theId) {
		// TODO Auto-generated method stub
		return companyMobileNumberDAO.getMobileNumber(theId);
	}

	@Override
	@Transactional
	public void saveMobileNumber(CompanyMobileNumber theCompanyMobileNumber) {
		// TODO Auto-generated method stub
		companyMobileNumberDAO.saveMobileNumber(theCompanyMobileNumber);
	}

	@Override
	@Transactional
	public void deleteMobileNumber(int theId) {
		// TODO Auto-generated method stub
		companyMobileNumberDAO.deleteMobileNumber(theId);
	}
}
