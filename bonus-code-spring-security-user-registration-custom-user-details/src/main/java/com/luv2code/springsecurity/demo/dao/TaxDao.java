package com.luv2code.springsecurity.demo.dao;

import java.util.List;

import com.luv2code.springsecurity.demo.entity.Tax;

public interface TaxDao {
	Tax getTax(String theName, String userName);
	
	void save(Tax toSave);
	
	List<Tax> getTaxByUserName(String userName);
}
