package com.anurag.client;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.anurag.dao.UserDAO;
import com.anurag.dao.UserDAOImpl;
import com.anurag.pojo.User;

public class Test {
	
	
	public static void main(String[] args) {
		
		ApplicationContext context=new
				ClassPathXmlApplicationContext("com/anurag/config/myBean.xml");
		UserDAO dao=context.getBean("userDao",UserDAOImpl.class);
		System.out.println("\n=============== serchUser(-)===================\n");
		List<User> users1=dao.serchUser("LIVE.COM");
		for (User user : users1) {
			System.out.println(user);
		}
		System.out.println("\n=============== getAllUser()===================\n");
		
		List<User>list=dao.getAllUsers();
		for (User user : list) {
			System.out.println(user);
		}
		System.out.println("\n=========updateUserProfile(newMobileNo , userID)============\n");
		
		int count=dao.updateUserProfile("+01-11111111111", 1110);
		System.out.println(count+" Records Updated");
		
		System.out.println("\n================removeUser(userID)===================\n");
		
		int cnt=dao.removeUser(1114);
		System.out.println(cnt+" Records Deleted");
		
		System.out.println("\n============createUser(user)==================\n");
		
		User user=new User();
		user.setUserID(1111);
		user.setName("ANURAG");
		user.setEmail("ANURAG@GMAIL.COM");
		user.setMobile("OO7");
		int uid=dao.createUser(user);
		
		System.out.println("User With UserID "+uid+" is Created" );

	}
}
