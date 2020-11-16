package com.luv2code.springsecurity.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springsecurity.demo.dao.GroupDao;
import com.luv2code.springsecurity.demo.entity.Group;
@Service
public class GroupServiceImpl implements GroupService {
	@Autowired
	private GroupDao groupDao;
	@Override
	public Group getGroup(String GroupName, Long scheduleId) {
		// TODO Auto-generated method stub
		return groupDao.getGroup(GroupName, scheduleId);
	}

	@Override
	public void save(Group theGroup) {
		// TODO Auto-generated method stub
		groupDao.save(theGroup);
	}

	@Override
	public List<Group> getGroupByScheduleId(Long scheduleId) {
		// TODO Auto-generated method stub
		return groupDao.getGroupByScheduleId(scheduleId);
	}

	@Override
	public List<Group> getGroupByUserName(String userName) {
		// TODO Auto-generated method stub
		return groupDao.getGroupByUserName(userName);
	}

	@Override
	public Group getGroupById(Long id) {
		// TODO Auto-generated method stub
		return groupDao.getGroupById(id);
	}

	@Override
	public Group getGroupByName(String groupName, String userName) {
		// TODO Auto-generated method stub
		return groupDao.getGroupByName(groupName, userName);
	}

}
