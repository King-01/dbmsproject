package com.luv2code.springsecurity.demo.dao;

import java.util.List;

import com.luv2code.springsecurity.demo.entity.Account;

public interface AccountDao {
	void save(Account theAccount);
	List<Account> getAccountByGroupId(Long groupId);
	Account getAccount(String AccountName, Long groupId);
	List<Account> getAccountByUserName(String UserName);
	Account getAccount(Long accountId);
}
