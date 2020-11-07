package com.luv2code.springsecurity.demo.service;

import java.util.List;

import com.luv2code.springsecurity.demo.entity.Schedule;

public interface ScheduleService {
	
	Schedule getSchedule(String ScheduleName, String UserName);
	
	void save(Schedule theSchedule);
	
	List<Schedule> getScheduleByUserName(String UserName);
	
	
}
