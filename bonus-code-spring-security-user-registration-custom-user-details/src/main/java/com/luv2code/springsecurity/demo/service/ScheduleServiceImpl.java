package com.luv2code.springsecurity.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springsecurity.demo.dao.ScheduleDao;
import com.luv2code.springsecurity.demo.entity.Schedule;
@Service
public class ScheduleServiceImpl implements ScheduleService {
	@Autowired
	private ScheduleDao scheduleDao;

	@Override
	@Transactional
	public void save(Schedule theSchedule) {
		// TODO Auto-generated method stub
		scheduleDao.save(theSchedule);
		
	}

	@Override
	@Transactional
	public List<Schedule> getScheduleByUserName(String UserName) {
		// TODO Auto-generated method stub
		return scheduleDao.getScheduleByUserName(UserName);
	}

	@Override
	@Transactional
	public Schedule getSchedule(String ScheduleName, String UserName) {
		// TODO Auto-generated method stub
		return scheduleDao.getSchedule(ScheduleName, UserName);
	}

	@Override
	@Transactional
	public Schedule get(Long id) {
		// TODO Auto-generated method stub
		return scheduleDao.get(id);
	}

}
