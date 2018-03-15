package com.anurag.beans;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
@Service("service")
public class CustomerBean {
	@Autowired
	private UserBean user;
	@Value("Monitor")
	private String order;
	@Value("02/20/2016")
	private Date date;
	public UserBean getUser() {
		return user;
	}
	public String getOrder() {
		return order;
	}
	public Date getDate() {
		return date;
	}
}
