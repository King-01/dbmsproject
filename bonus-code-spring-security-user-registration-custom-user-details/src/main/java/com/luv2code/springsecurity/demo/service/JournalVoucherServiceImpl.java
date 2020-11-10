package com.luv2code.springsecurity.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springsecurity.demo.dao.JournalVoucherDao;
import com.luv2code.springsecurity.demo.entity.JournalVoucher;
@Service
public class JournalVoucherServiceImpl implements JournalVoucherService {
	@Autowired
	private JournalVoucherDao journalVoucherDao;

	@Override
	public JournalVoucher getJournalVoucher(Long id) {
		// TODO Auto-generated method stub
		return journalVoucherDao.getJournalVoucher(id);
	}

	@Override
	public List<JournalVoucher> getJournalVoucher(Long accountId, String userName) {
		// TODO Auto-generated method stub
		return journalVoucherDao.getJournalVoucher(accountId, userName);
	}

	@Override
	public void save(JournalVoucher toSave) {
		// TODO Auto-generated method stub
		journalVoucherDao.save(toSave);
	}

	@Override
	public List<JournalVoucher> getJournalVoucherByAccountId(Long id) {
		// TODO Auto-generated method stub
		return journalVoucherDao.getJournalVoucherByAccountId(id);
	}

	@Override
	public List<JournalVoucher> getJournalVoucherByDate(Date curDate, String userName) {
		// TODO Auto-generated method stub
		return journalVoucherDao.getJournalVoucherByDate(curDate, userName);
	}

	@Override
	public List<JournalVoucher> getJournalVoucherByUserName(String userName) {
		// TODO Auto-generated method stub
		return journalVoucherDao.getJournalVoucherByUserName(userName);
	}

	@Override
	public List<JournalVoucher> getJournalVoucherBetweenDates(Date curDate, Date endDate, String userName) {
		// TODO Auto-generated method stub
		return journalVoucherDao.getJournalVoucherBetweenDates(curDate, endDate, userName);
	}

}
