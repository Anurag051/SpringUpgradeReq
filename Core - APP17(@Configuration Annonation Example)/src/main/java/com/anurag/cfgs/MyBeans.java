package com.anurag.cfgs;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.anurag.beans.DAO;
import com.anurag.beans.Service;

@Configuration
public class MyBeans {

	@Bean(name="service",autowire=Autowire.BY_TYPE)
	public Service service() {
		return new Service();
	}
	@Bean(name="dao")//Taking default value i.e -> autowire=Autowire.BY_NAME
	public DAO dao() {
		return new DAO();
	}
}
