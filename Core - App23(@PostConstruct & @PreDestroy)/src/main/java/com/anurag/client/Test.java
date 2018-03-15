package com.anurag.client;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.anurag.beans.Cashier;
import com.anurag.beans.ShopingCart;

public class Test {
	public static void main(String[] args) {
		//working with ApplicationContext Container
		
		String cfgFile = "com/anurag/cfg/MyBean.xml";
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext(cfgFile);
		ShopingCart shopingcart = context.getBean("shopingCart", ShopingCart.class);
		Cashier cashier = (Cashier) context.getBean("cashier");
		cashier.calculateTotalPrice(shopingcart);
		System.out.println("Data Added Successfully");
		context.close();//to call destroy method
	
		
	}
}