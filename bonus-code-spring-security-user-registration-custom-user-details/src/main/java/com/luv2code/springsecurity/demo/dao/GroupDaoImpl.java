package com.luv2code.springsecurity.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springsecurity.demo.entity.Group;
import com.luv2code.springsecurity.demo.entity.Schedule;
@Repository
public class GroupDaoImpl implements GroupDao {
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	@Transactional
	public void save(Group theGroup) {
		// TODO Auto-generated method stub
		Session crs = sessionFactory.getCurrentSession();
		crs.saveOrUpdate(theGroup);
	}

	@Override
	@Transactional
	public List<Group> getGroupByScheduleId(Long scheduleId) {
		// TODO Auto-generated method stub
		Session crs = sessionFactory.getCurrentSession();
		Query theQuery = crs.createQuery("from Group where schedule=:scheduleId", Group.class);
		theQuery.setParameter("scheduleId", scheduleId);
		List<Group> toReturn = theQuery.getResultList();
		return toReturn;
	}

	@Override
	@Transactional
	public Group getGroup(String GroupName, Long scheduleId) {
		// TODO Auto-generated method stub
		Session crs = sessionFactory.getCurrentSession();
		Query<Group> theQuery = crs.createQuery("from Group where schedule=:scheduleId and groupName=:GroupName", Group.class);
		theQuery.setParameter("scheduleId", scheduleId);
		theQuery.setParameter("GroupName", GroupName);
		Group toReturn = theQuery.getSingleResult();
		return toReturn;
	}

	@Override
	@Transactional
	public List<Group> getGroupByUserName(String userName) {
		// TODO Auto-generated method stubString userName = ((UserDetails)authentication).getUsername();
		Session crs = sessionFactory.getCurrentSession();
		Query theQuery = crs.createQuery("from Schedule where userName=:UserName", Schedule.class
				);
		theQuery.setParameter("UserName", userName);
		List<Schedule> theList = theQuery.getResultList();
		List<Group> theGroupList = new ArrayList<Group>();
		for(int i = 0; i < theList.size(); i++)
		{
			Long scheduleId = theList.get(i).getId();
			Session crs1 = sessionFactory.getCurrentSession();
			Query nextQuery = crs1.createQuery("from Group where schedule=:scheduleId", Group.class);
			nextQuery.setParameter("scheduleId", scheduleId);
			List<Group> itmList = nextQuery.getResultList();
			for(int j = 0; j < itmList.size(); j++)
			{
				theGroupList.add(itmList.get(j));
			}
		}
		return theGroupList;
	}

}
