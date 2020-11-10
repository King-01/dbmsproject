package com.luv2code.springsecurity.demo.dao;

import java.util.Date;
import java.util.List;

import com.luv2code.springsecurity.demo.entity.JournalVoucher;

public interface JournalVoucherDao {
	JournalVoucher getJournalVoucher(Long id);
	List<JournalVoucher> getJournalVoucher(Long accountId, String userName);
	
	void save(JournalVoucher toSave);
	List<JournalVoucher> getJournalVoucherByAccountId(Long id);
	List<JournalVoucher> getJournalVoucherByDate(Date curDate, String userName);
	List<JournalVoucher> getJournalVoucherByUserName(String userName);
	List<JournalVoucher> getJournalVoucherBetweenDates(Date curDate, Date endDate, String userName);

}
