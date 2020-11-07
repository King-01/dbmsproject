package com.luv2code.springsecurity.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springsecurity.demo.entity.Account;
import com.luv2code.springsecurity.demo.entity.Group;
import com.luv2code.springsecurity.demo.entity.StockItem;
import com.luv2code.springsecurity.demo.service.GroupService;
@Repository
public class StockItemDaoImpl implements StockItemDao {
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private GroupService groupService;

	@Override
	@Transactional
	public void save(StockItem theStockItem) {
		// TODO Auto-generated method stub
		Session crs = sessionFactory.getCurrentSession();
		crs.saveOrUpdate(theStockItem);
	}

	@Override
	@Transactional
	public List<StockItem> getStockItemByGroupId(Long groupId) {
		// TODO Auto-generated method stub
		Session crs = sessionFactory.getCurrentSession();
		Query theQuery = crs.createQuery("from StockItem where groupId=:GroupId", StockItem.class);
		theQuery.setParameter("GroupId", groupId);
		List<StockItem> toReturn = theQuery.getResultList();
		return toReturn;
	}

	@Override
	@Transactional
	public StockItem getStockItem(String StockItemName, Long groupId) {
		// TODO Auto-generated method stub
		Session crs = sessionFactory.getCurrentSession();
		Query<StockItem> theQuery = crs.createQuery("from StockItem where groupId=:GroupId and stockItemName=:StockItemName", StockItem.class);
		theQuery.setParameter("GroupId", groupId);
		theQuery.setParameter("StockItemName", StockItemName);
		StockItem toReturn = theQuery.getSingleResult();
		return toReturn;
	}

	@Override
	@Transactional
	public List<StockItem> getStockItemByUserName(String UserName) {
		// TODO Auto-generated method stub
		List<Group> theList = groupService.getGroupByUserName(UserName);
		List<StockItem> theStockItemList = new ArrayList<StockItem>();
		for(int i = 0; i < theList.size(); i++)
		{
			Long groupId = theList.get(i).getId();
			Session crs1 = sessionFactory.getCurrentSession();
			Query nextQuery = crs1.createQuery("from StockItem where groupId=:GroupId", StockItem.class);
			nextQuery.setParameter("GroupId", groupId);
			List<StockItem> itmList = nextQuery.getResultList();
			for(int j = 0; j < itmList.size(); j++)
			{
				theStockItemList.add(itmList.get(j));
			}
		}
		return theStockItemList;
	}
	
	

}
