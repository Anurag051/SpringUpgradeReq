package com.anurag.client;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.anurag.beans.Service;

@SuppressWarnings("deprecation")
public class Test {

	public static void main(String[] args) {
		Resource parentResource=new ClassPathResource("com/anurag/cfg/dao-beans.xml");
		BeanFactory parentFactory = new XmlBeanFactory(parentResource);
		Resource childResource=new ClassPathResource("com/anurag/cfg/service-beans.xml");
		BeanFactory factory = new XmlBeanFactory(childResource, parentFactory);
		Service ser =factory.getBean("service", Service.class);
		ser.serviceMethod();

	}

}
