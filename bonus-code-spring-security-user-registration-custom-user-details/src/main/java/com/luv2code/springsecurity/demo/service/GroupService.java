package com.luv2code.springsecurity.demo.service;

import java.util.List;

import com.luv2code.springsecurity.demo.entity.Group;

public interface GroupService {
	
	Group getGroup(String GroupName, Long scheduleId);
	
	void save(Group theGroup);
	
	List<Group> getGroupByScheduleId(Long scheduleId);
	List<Group> getGroupByUserName(String userName);
	
}
