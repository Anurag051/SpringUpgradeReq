package com.anurag.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.anurag.dao.BookShopDAO;

public class Test {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		ApplicationContext context= new ClassPathXmlApplicationContext
															("com/anurag/config/applicationContext.xml");
		
		BookShopDAO dao=context.getBean("bookShopDao", BookShopDAO.class);
		dao.purchase("SP102", 1001, 8);
		
	}

}
