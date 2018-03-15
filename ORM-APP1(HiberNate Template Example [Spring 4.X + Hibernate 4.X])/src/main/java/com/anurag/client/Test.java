package com.anurag.client;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.anurag.dao.UserDAO;
import com.anurag.pojo.User;


@SuppressWarnings("unused")
public class Test {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		ApplicationContext context=new
				ClassPathXmlApplicationContext("com/anurag/config/myBean.xml");
		
		UserDAO dao=context.getBean("userDao",UserDAO.class);
		System.out.println("\n=============== getUser(-)===================\n");
		User user1=dao.getUser(1001);
		System.out.println(user1.getName()+"\t"+user1.getEmail()+"\t"+user1.getMobile());
		System.out.println("\n=============== getAllUsers(-)===================\n");
		List<User>list=dao.getAllUsers();
		for (User user2 : list) {
			System.out.println(user2);
		}	
		System.out.println("\n=============== createUser(-)===================\n");
		User user = new User();
		user.setUserID((long) 1015);
		user.setName("VENKY");
		user.setAge((byte) 26);
		user.setMobile("+91-9874563210");
		user.setEmail("VENKY@IND.COM");
		Long uid=dao.createUser(user);
		System.out.println("Record Inserted With UID : "+uid);
	
		System.out.println("\n=============== deleteUser(-)===================\n");
		int count=dao.deleteUser(1010);
		System.out.println(count+" records Removed ");
		System.out.println("\n=============== updateUser(-)===================\n");
		User user2=new User();
		user2.setEmail("update@update.com");
		user2.setMobile("+0-0000000012");
		user2.setName("Updated");
		user2.setUserID((long) 1008);
		int count1=dao.updateUserProfile(user2);
		System.out.println(count1+" Records Updated");
	}
}
