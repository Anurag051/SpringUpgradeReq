package com.anurag.client;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.anurag.beans.Cashier;
import com.anurag.beans.ShopingCart;

@SuppressWarnings("deprecation")
public class Test {
	public static void main(String[] args) {
		String cfgFile = "com/anurag/cfg/myBeans.xml";
		Resource resource = new ClassPathResource(cfgFile);
		BeanFactory factory = new XmlBeanFactory(resource);
		ShopingCart shopingcart = factory.getBean("shopingCart", ShopingCart.class);
		Cashier cashier = (Cashier) factory.getBean("cashier");
		cashier.calculateTotalPrice(shopingcart);
		System.out.println("Data Added Successfully");
	}
}