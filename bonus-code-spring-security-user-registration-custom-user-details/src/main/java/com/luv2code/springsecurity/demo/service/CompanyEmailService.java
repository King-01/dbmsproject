package com.luv2code.springsecurity.demo.service;

import java.util.List;

import com.luv2code.springsecurity.demo.entity.CompanyEmail;

public interface CompanyEmailService {
	List<CompanyEmail> getEmail(String userName);
	CompanyEmail getEmail(int theId);
	void saveEmail(CompanyEmail theCompanyEmail);
	void deleteEmail(int theId);
}
