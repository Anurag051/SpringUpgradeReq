package com.anurag.client;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.anurag.beans.Cashier;
import com.anurag.beans.ShopingCart;

@SuppressWarnings({ "deprecation", "unused" })
public class Test {
	public static void main(String[] args) {
		//working with ApplicationContext Container
		
		/*
		String cfgFile = "com/anurag/cfgs/myBean.xml";
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext(cfgFile);
		ShopingCart shopingcart = context.getBean("shopingCart", ShopingCart.class);
		Cashier cashier = (Cashier) context.getBean("cashier");
		cashier.calculateTotalPrice(shopingcart);
		System.out.println("Data Added Successfully");
		context.close();//to call destroy method
		*/
		
		//working with BeanFactory Container
		
		
		
			String cfgFile = "com/anurag/cfgs/myBean.xml";
			XmlBeanFactory beanFactory=new XmlBeanFactory(new ClassPathResource(cfgFile));
			ShopingCart shopingcart = beanFactory.getBean("shopingCart", ShopingCart.class);
			Cashier cashier = (Cashier) beanFactory.getBean("cashier");
			cashier.calculateTotalPrice(shopingcart);
			System.out.println("Data Added Successfully");
			beanFactory.destroySingletons();//to call destroy method
			
			
			
	}
}