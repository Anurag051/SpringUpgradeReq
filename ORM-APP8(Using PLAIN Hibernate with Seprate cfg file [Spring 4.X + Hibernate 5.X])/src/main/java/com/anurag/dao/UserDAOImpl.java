package com.anurag.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.anurag.pojo.User;


@Repository("userDao")
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public int createUser(User user) {

		// using Save Method(Single Row Operations)

		Session session = sessionFactory.openSession();
		Transaction tx = null;
		int uid = 0;
		try {
			tx = session.beginTransaction();
			uid = (Integer) session.save(user);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			System.out.println
			("Exception occured in createUser(-) of UserDAOImpl class " + e.getMessage());
		}
		return uid;
	}

	public List<User> getAllUsers() {

		// getting all Records Based On Criteria (QBC)
		
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(User.class);
		@SuppressWarnings("unchecked")
		List<User> users = criteria.list();
		return users;
	}

	public int updateUserProfile(String newMobileNo, int userID) {

		// updating mobile no using HQL

		Session session = sessionFactory.openSession();
		Transaction tx = null;
		int count = 0;
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("update User set mobile = :phone where userID= :uid");
			query.setParameter("phone", newMobileNo);
			query.setParameter("uid", userID);
			count = query.executeUpdate();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
		return count;
	}

	public List<User> serchUser(String emailType) {

		// Serch Based on Email Type using HQL
		
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("From User where email like :mail");
		String email = "%" + emailType + "%";
		query.setParameter("mail", email);
		@SuppressWarnings("unchecked")
		List<User> list = query.list();
		return list;

	}

	public int removeUser(int userID) {

		// Deleting Record Based on NativeSQL
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		int count = 0;
		try {
			tx = session.beginTransaction();
			SQLQuery query = session.createSQLQuery
					("delete from user_details where uid= :id");
			query.setParameter("id", userID);
			count = query.executeUpdate();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
		return count;
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> getAllUsersNameAndMobileNo() {
		
		//Using HQL
		
		Session session=sessionFactory.openSession();
		String hql = "select name,mobile from User";
		Query query=session.createQuery(hql);
		List<Object[]>list=query.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public long getTotalRecordsCount() {
		//Using QBC
		Session session=sessionFactory.openSession();
		Criteria criteria=session.createCriteria(User.class);
		Projection p1=Projections.count("userID");
		criteria.setProjection(p1);
		List<Long>list=criteria.list();
		long count=list.get(0);
		return count;
	}

	@SuppressWarnings("unchecked")
	public List<User> getUserBasedOnRange(int min, int max) {
		//using HQL
		Query query = sessionFactory.openSession().createQuery("from User where userID >= :p_min and userID<= :p_max");
		query.setParameter("p_min", min);
		query.setParameter("p_max", max);
		List<User> list = query.list();
		return list;
	}

	public int removeUser(String name) {
		
		Session session=sessionFactory.openSession();
		String hql = "delete from User where name=?";
		Query query=session.createQuery(hql);
		query.setParameter(0, name);
		int count=query.executeUpdate();
		return count;
	}
}
