package com.anurag.dao;

import java.util.List;

import com.anurag.pojo.User;

public interface UserDAO {
	
	public long createUser(User user);
	public User getUser(long userID);
	public List<User>getAllUsers();
	public void updateUserProfile(User user);
	public void deleteUser(long userID);

}
