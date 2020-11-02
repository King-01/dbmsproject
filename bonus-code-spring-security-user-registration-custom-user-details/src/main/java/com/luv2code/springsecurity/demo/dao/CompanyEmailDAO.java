package com.luv2code.springsecurity.demo.dao;

import java.util.List;

import com.luv2code.springsecurity.demo.entity.CompanyEmail;

public interface CompanyEmailDAO {
	List<CompanyEmail> getEmail(String userName);
	CompanyEmail getEmail(int theId);
	void saveEmail(CompanyEmail theCompanyEmail);
	void deleteEmail(int theId);
}
