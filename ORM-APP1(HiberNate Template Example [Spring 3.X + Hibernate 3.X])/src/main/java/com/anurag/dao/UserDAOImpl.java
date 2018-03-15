package com.anurag.dao;

import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import com.anurag.pojo.User;

public class UserDAOImpl implements UserDAO {

	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public long createUser(User user) {
		Long uid = (Long) hibernateTemplate.save(user);
		return uid;
	}

	public User getUser(long userID) {
		User user = hibernateTemplate.get(User.class, userID);
		return user;
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		// using HQL
		List<User> list = hibernateTemplate.find("from com.anurag.pojo.User");
		return list;
	}

	public void updateUserProfile(User user) {
		hibernateTemplate.saveOrUpdate(user);
		System.out.println("Record Inserted Or Updated");
	}

	public void deleteUser(long userID) {
		
		User user = hibernateTemplate.load(User.class, userID);
		hibernateTemplate.delete(user);
		System.out.println("Record Deleted");
	}

}
