package com.anurag.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@ComponentScan(basePackages={"com.anurag.dao","com.anurag.service"})
public class MyBeans {
	
	@Value("${mysql.driverClassName}")
	private String driverClassName;
	
	@Value("${mysql.url}")
	private String url;
	
	@Value("${mysql.userName}")
	private String userName;
	
	@Value("${mysql.password}")
	private String password;
	
	@Bean
	public DataSource dataSource(){
		BasicDataSource dataSource= new BasicDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(userName);
		dataSource.setPassword(password);
		return dataSource;
	}
	@Bean
	public static PropertyPlaceholderConfigurer placeholderConfigurer(){
		PropertyPlaceholderConfigurer configurer=new PropertyPlaceholderConfigurer();
		configurer.setLocation(new ClassPathResource("database.properties"));
		return configurer;
	}

}
