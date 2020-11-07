package com.luv2code.springsecurity.demo.dao;

import java.util.List;

import com.luv2code.springsecurity.demo.entity.Schedule;

public interface ScheduleDao {
	void save(Schedule theSchedule);
	List<Schedule> getScheduleByUserName(String UserName);
	Schedule getSchedule(String ScheduleName, String UserName);
}
