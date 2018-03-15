package com.anurag.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.anurag.pojo.User;

@Repository("userDao")
public class UserDAOImpl extends HibernateDaoSupport implements UserDAO {
	
	@Autowired
	public UserDAOImpl(HibernateTemplate hibernateTemplate) {
		setHibernateTemplate(hibernateTemplate);
	}
	@Transactional(readOnly=false)
	public int createUser(User user) {
		int userId = (Integer) getHibernateTemplate().save(user);
		return userId;
	}

	public List<User> getAllUsers() {

		List<User> list = getHibernateTemplate().execute(new HibernateCallback<List<User>>() {

			public List<User> doInHibernate(Session session) throws HibernateException {

				// getting all Records Based On Criteria (QBC)
				Criteria criteria = session.createCriteria(User.class);
				@SuppressWarnings("unchecked")
				List<User> users = criteria.list();
				return users;
			}
		});
		return list;
	}

	public int updateUserProfile(final String newMobileNo, final int userID) {
		// updating mobile no using HQL
		int count = getHibernateTemplate().execute(new HibernateCallback<Integer>() {

			public Integer doInHibernate(Session session) throws HibernateException {

				Transaction tx = session.beginTransaction();
				Query query = session.createQuery("update User set mobile = :phone where userID= :uid");

				query.setParameter("phone", newMobileNo);
				query.setParameter("uid", userID);
				Integer count = query.executeUpdate();
				tx.commit();
				return count;
			}
		});
		return count;
	}

	public List<User> serchUser(String emailType) {
		// Serch Based on Email Type using HQL
		Session session = getSessionFactory().openSession();
		Query query = session.createQuery("From User where email like :mail");
		String email = "%" + emailType + "%";
		query.setParameter("mail", email);
		@SuppressWarnings("unchecked")
		List<User> list = query.list();
		return list;
	}

	public int removeUser( int userID) {
		// Deleting Record Based on NativeSQL

		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery("delete from user_details where uid= :id");
		query.setParameter("id", userID);
		int count = query.executeUpdate();
		tx.commit();
		return count;
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> getAllUsersNameAndMobileNo() {
		String hql = "select name,mobile from User";
		List<Object[]> list = (List<Object[]>) getHibernateTemplate().find(hql);
		return list;
	}

	@SuppressWarnings("unchecked")
	public long getTotalRecordsCount() {
		String hql = "select count(*) from User";
		List<Long> list = (List<Long>) getHibernateTemplate().find(hql);
		long count = list.get(0);
		return count;
	}

	@SuppressWarnings("unchecked")
	public List<User> getUserBasedOnRange(int min, int max) {
		Query query = getSessionFactory().openSession().createQuery
				("from User where userID >= :p_min and userID<= :p_max");
		query.setParameter("p_min", min);
		query.setParameter("p_max", max);
		List<User> list = query.list();
		return list;
	}

	public int removeUser(String name) {

		String hql = "delete from User where name=?";
		int count = getHibernateTemplate().bulkUpdate(hql, name);
		return count;
	}

}
