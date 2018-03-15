package com.anurag.beans;

import org.springframework.stereotype.Component;

@Component("service")
public class Service {

	private DAO dao;

	public void setDao(DAO dao) {
		this.dao = dao;
	}
	
	public void serviceMethod() {
		System.out.println("Service : Service Method");
		dao.daoMethod();
	}

}
