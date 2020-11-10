package com.luv2code.springsecurity.demo.service;

import java.util.List;

import com.luv2code.springsecurity.demo.entity.Account;

public interface AccountService {

	Account getAccount(String AccountName, Long groupId);
	Account getAccount(Long accountId);
	
	void save(Account theAccount);
	
	List<Account> getAccountByGroupId(Long groupId);
	List<Account> getAccountByUserName(String userName);
	
}
