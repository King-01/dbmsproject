package com.luv2code.springsecurity.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springsecurity.demo.dao.TaxDao;
import com.luv2code.springsecurity.demo.entity.Tax;
@Service
public class TaxServiceImpl implements TaxService {
	@Autowired
	private TaxDao taxDao;

	@Override
	public Tax getTax(String theName, String userName) {
		// TODO Auto-generated method stub
		return taxDao.getTax(theName, userName);
	}

	@Override
	public void save(Tax toSave) {
		// TODO Auto-generated method stub
		taxDao.save(toSave);
	}

	@Override
	public List<Tax> getTaxByUserName(String userName) {
		// TODO Auto-generated method stub
		return taxDao.getTaxByUserName(userName);
	}

	@Override
	public Tax get(Long id) {
		// TODO Auto-generated method stub
		return taxDao.get(id);
	}

}
