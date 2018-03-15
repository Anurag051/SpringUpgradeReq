package com.anurag.client;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.anurag.dao.UserDAO;
import com.anurag.pojo.User;

public class Test {
	
	
	public static void main(String[] args) {
		
		ApplicationContext context=new
				ClassPathXmlApplicationContext("com/anurag/config/myBean.xml");
		UserDAO dao=context.getBean("userDao",UserDAO.class);
		System.out.println("\n=============== serchUser(-)=====================================================\n");
		List<User> users1=dao.serchUser("LIVE.COM");
		for (User user : users1) {
			System.out.println(user);
		}
		System.out.println("\n=============== getAllUser()====================================================\n");
		
		List<User>list=dao.getAllUsers();
		for (User user : list) {
			System.out.println(user);
		}
		System.out.println("\n=========updateUserProfile(newMobileNo , userID)======================================\n");
		
		int count=dao.updateUserProfile("+01-11111111111", 1110);
		System.out.println(count+" Records Updated");
		
		System.out.println("\n================removeUser(userID)===============================================\n");
		
		int cnt=dao.removeUser(1114);
		System.out.println(cnt+" Records Deleted");
			
		System.out.println("\n============createUser(user)===================================================\n");
		
		User user=new User();
		user.setUserID(1112);
		user.setName("ANURAG");
		user.setEmail("ANURAG@GMAIL.COM");
		user.setMobile("OO7");
		int uid=dao.createUser(user);
		
		System.out.println("User With UserID "+uid+" is Created" );
		
		System.out.println("\n==========getTotalRecordsCount()================================================\n");
		
		System.out.println("Total No Of Records : "+dao.getTotalRecordsCount());
		
		System.out.println("\n==========getUserBasedOnRange(min,max)========================================\n");
		
		List<User>list2=dao.getUserBasedOnRange(1000, 1005);
		for (User user1 : list2) {
			System.out.println(user1);
		}
		System.out.println("\n==========removeUser(name)============================================\n");
		
		int count1 =dao.removeUser("ANURAG");
		
		System.out.println(count1+" Record(S) Deleted");
		
		System.out.println("\n=========getAllUsersNameAndMobileNo()====================================\n");
		List<Object[]>list3=dao.getAllUsersNameAndMobileNo();
		for (Object[] objects : list3) {
			for (Object object : objects) {
				System.out.print(object+"\t\t");
			}
			System.out.println();
		}
	}
}
