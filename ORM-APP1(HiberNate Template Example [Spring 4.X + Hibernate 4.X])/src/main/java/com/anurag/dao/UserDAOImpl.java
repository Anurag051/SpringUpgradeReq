package com.anurag.dao;

import java.util.List;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.anurag.pojo.User;

public class UserDAOImpl implements UserDAO {

	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
		@Transactional(readOnly=false)
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
		List<User> list = (List<User>) hibernateTemplate.find("from com.anurag.pojo.User");
		return list;
	}

	public int updateUserProfile(User user) {

		// HQL
		String hql = "Update com.anurag.pojo.User as u set u.name=?," + "u.email=?,u.mobile=? where u.userID=?";

		int count = hibernateTemplate.bulkUpdate(hql, user.getName(), user.getEmail(), user.getMobile(),
				user.getUserID());
	
		return count;
	}

	public int deleteUser(long userID) {
		// using HQL
		String hql = "delete from User as u where u.userID=?";
		int count = hibernateTemplate.bulkUpdate(hql, userID);
		return count;
	}

}
