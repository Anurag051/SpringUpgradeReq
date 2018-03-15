package com.anurag.dao;

import java.util.List;

import com.anurag.pojo.User;

public interface UserDAO {
	
	public int createUser(User user);
	public List<User>serchUser(String emailType);
	public List<User>getAllUsers();
	public int updateUserProfile(String newMobileNo , int userID);
	public int removeUser(int userID);

}
