package com.luv2code.springsecurity.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springsecurity.demo.entity.Schedule;

@Repository
public class ScheduleDaoImpl implements ScheduleDao {
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public void save(Schedule theSchedule) {
		// TODO Auto-generated method stub
		Session crs = sessionFactory.getCurrentSession();
		crs.saveOrUpdate(theSchedule);
	}

	@Override
	public List<Schedule> getScheduleByUserName(String UserName) {
		// TODO Auto-generated method stub
		Session crs = sessionFactory.getCurrentSession();
		Query<Schedule> theQuery = crs.createQuery("from Schedule where username_id=:UserName", Schedule.class);
		theQuery.setParameter("UserName", UserName);
		List<Schedule> toReturn = theQuery.getResultList();
		return toReturn;
	}

	@Override
	public Schedule getSchedule(String ScheduleName, String UserName) {
		// TODO Auto-generated method stub
		Session crs = sessionFactory.getCurrentSession();
		Query<Schedule> theQuery = crs.createQuery("from Schedule where username_id=:UserName and name=:ScheduleName", Schedule.class);
		theQuery.setParameter("UserName", UserName);
		theQuery.setParameter("ScheduleName", ScheduleName);
		Schedule toReturn = theQuery.getSingleResult();
		return toReturn;
	}

	@Override
	public Schedule get(Long id) {
		// TODO Auto-generated method stub
		Session crs = sessionFactory.getCurrentSession();
		return crs.get(Schedule.class, id);
	}

}
