package com.luv2code.springsecurity.demo.dao;

import java.util.List;

import com.luv2code.springsecurity.demo.entity.CompanyMobileNumber;

public interface CompanyMobileNumberDAO {
	List<CompanyMobileNumber> getMobileNumber(String userName);
	CompanyMobileNumber getMobileNumber(int theId);
	void saveMobileNumber(CompanyMobileNumber theCompanyMobileNumber);
	void deleteMobileNumber(int theId);
}
