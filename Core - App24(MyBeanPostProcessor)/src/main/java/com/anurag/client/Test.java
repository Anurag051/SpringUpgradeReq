package com.anurag.client;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.anurag.beans.Cashier;
import com.anurag.beans.MyBeanPostProcessor;
import com.anurag.beans.ShopingCart;

@SuppressWarnings({ "unused", "deprecation" })
public class Test {
	public static void main(String[] args) {
		//working with ApplicationContext Container
		
		String cfgFile = "com/anurag/cfg/MyBean.xml";
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext(cfgFile);
		MyBeanPostProcessor myBeanPostProcessor=
				context.getBean("myBeanPostProcessor", MyBeanPostProcessor.class);
		ShopingCart shopingcart = context.getBean("shopingCart", ShopingCart.class);
		Cashier cashier = (Cashier) context.getBean("cashier");
		cashier.calculateTotalPrice(shopingcart);
		System.out.println("Data Added Successfully");
		context.close();//to call destroy method
	
		//working with BeanFactory Container
		
		/*
		XmlBeanFactory beanFactory=new 
				XmlBeanFactory(new ClassPathResource("com/anurag/cfg/MyBean.xml"));
		MyBeanPostProcessor myBeanPostProcessor=
				beanFactory.getBean("myBeanPostProcessor", MyBeanPostProcessor.class);
		beanFactory.addBeanPostProcessor(myBeanPostProcessor);
		Cashier cashier=beanFactory.getBean("cashier", Cashier.class);
		ShopingCart cart=beanFactory.getBean("shopingCart", ShopingCart.class);
		cashier.calculateTotalPrice(cart);
		System.out.println("Data Added Successfully");
		beanFactory.destroySingletons();//to call destroy method
		*/
	}
}