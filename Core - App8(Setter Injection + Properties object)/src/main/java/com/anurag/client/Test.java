package com.anurag.client;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.anurag.beans.DataBaseProperties;

@SuppressWarnings("deprecation")
public class Test 
{
    public static void main( String[] args )
    {
    	Resource resource=new ClassPathResource("com/anurag/cfg/MyBean.xml");
       BeanFactory factory = new XmlBeanFactory(resource);
       DataBaseProperties db =factory.getBean("dbprop", DataBaseProperties.class);
       db.displayDetails();
    }
}
