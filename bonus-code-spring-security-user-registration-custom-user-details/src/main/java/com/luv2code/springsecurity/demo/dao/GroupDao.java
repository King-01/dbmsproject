package com.luv2code.springsecurity.demo.dao;

import java.util.List;

import com.luv2code.springsecurity.demo.entity.Group;

public interface GroupDao {
	void save(Group theGroup);
	List<Group> getGroupByScheduleId(Long scheduleId);
	Group getGroup(String GroupName, Long scheduleId);
	List<Group> getGroupByUserName(String UserName);
	Group getGroupById(Long id);
	Group getGroupByName(String groupName, String userName);
}
