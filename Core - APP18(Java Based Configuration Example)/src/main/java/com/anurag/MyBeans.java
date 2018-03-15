package com.anurag;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration

public class MyBeans {
	
	@Value("${oracle.driverClassName}")
	private String driverClassName;
	
	@Value("${oracle.url}")
	private String url;
	
	@Value("${oracle.userName}")
	private String username;
	
	@Value("${oracle.password}")
	private String password;
	
	@Bean(name="dataSource")
	public DataSource dataSource(){
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		dataSource.setUrl(url);
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		
		return dataSource;
	}
	@Bean
	public static PropertyPlaceholderConfigurer propertyPlaceholderConfigurer(){
		
		PropertyPlaceholderConfigurer placeholderConfigurer = new PropertyPlaceholderConfigurer();
		Resource resource = new ClassPathResource("com/anurag/cfgs/database.properties");
		placeholderConfigurer.setLocation(resource);
		return placeholderConfigurer;
	}

}
