package com.luv2code.springsecurity.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springsecurity.demo.dao.AccountDao;
import com.luv2code.springsecurity.demo.entity.Account;
@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountDao accountDao;

	@Override
	public Account getAccount(String AccountName, Long groupId) {
		// TODO Auto-generated method stub
		return accountDao.getAccount(AccountName, groupId);
	}

	@Override
	public void save(Account theAccount) {
		// TODO Auto-generated method stub
		accountDao.save(theAccount);
	}

	@Override
	public List<Account> getAccountByGroupId(Long groupId) {
		// TODO Auto-generated method stub
		return accountDao.getAccountByGroupId(groupId);
	}

	@Override
	public List<Account> getAccountByUserName(String userName) {
		// TODO Auto-generated method stub
		return accountDao.getAccountByUserName(userName);
	}

	@Override
	public Account getAccount(Long accountId) {
		// TODO Auto-generated method stub
		return accountDao.getAccount(accountId);
	}

	@Override
	public Account getAccount(String accountName) {
		// TODO Auto-generated method stub
		return accountDao.getAccount(accountName);
	}
	
}
