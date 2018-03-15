package com.anurag.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import com.anurag.pojo.User;

public class UserDAOImpl implements UserDAO {

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public int createUser(final User user) {
		
		int userId=hibernateTemplate.execute(new HibernateCallback<Integer>() {
			//insert Operation Using Save(-) method
			public Integer doInHibernate(Session session) throws HibernateException {
				 Transaction tx=session.beginTransaction();
				Integer uid = (Integer) session.save(user);
				//session.saveOrUpdate(user);
				tx.commit();
				return uid;
			}
		});
		
		return userId;
	}

	public List<User> getAllUsers() {
		
		List<User>list=hibernateTemplate.execute(new HibernateCallback<List<User>>() {

			public List<User> doInHibernate(Session session) throws HibernateException {
				
				//getting all Records Based On Criteria (QBC) 
				Criteria criteria=session.createCriteria(User.class);
				@SuppressWarnings("unchecked")
				List<User>users=criteria.list();
				return users;
			}
		});
		return list;
	}

	public int updateUserProfile(final String newMobileNo , final int userID) {
		// updating mobile no using HQL
		int count=hibernateTemplate.execute(new HibernateCallback<Integer>() {

			public Integer doInHibernate(Session session) throws HibernateException {
				
				Transaction tx=session.beginTransaction();
				Query query=session.createQuery
						("update User set mobile = :phone where userID= :uid");
				
				query.setParameter("phone", newMobileNo);
				query.setParameter("uid", userID);
				Integer count=query.executeUpdate();
				tx.commit();
				return count;
			}
		});
		return count;
	}


	public List<User>serchUser(final String emailType) {
		// Serch Based on Email Type using HQL
		List<User>users=hibernateTemplate.execute(new HibernateCallback<List<User>>() {

			public List<User> doInHibernate(Session session) throws HibernateException {
				
				Query query=session.createQuery("From User where email like :mail");
				String email="%"+emailType+"%";
				query.setParameter("mail", email);
				@SuppressWarnings("unchecked")
				List<User>list=query.list();
				return list;
			}
		});
		return users;
	}

	public int removeUser(final int userID) {
		// Deleting Record Based on NativeSQL
		int cnt=hibernateTemplate.execute(new HibernateCallback<Integer>() {

			public Integer doInHibernate(Session session) throws HibernateException {
				//using  NativeSQL
				Transaction tx=session.beginTransaction();
				SQLQuery query=session.createSQLQuery
						("delete from user_details where uid= :id");
				query.setParameter("id", userID);
				Integer count=query.executeUpdate();
				tx.commit();
				return count;
			}
		});
		return cnt;
	}

	
	
}
