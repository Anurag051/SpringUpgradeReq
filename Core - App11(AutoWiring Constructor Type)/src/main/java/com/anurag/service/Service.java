package com.anurag.service;

import com.anurag.dao.DAO;

public class Service {
	private DAO dao;
	
	public Service(DAO dao) {
		System.out.println("Service Constructor with DAO parameter");
		this.dao = dao;
	}

	public void serviceMethod() {
		dao.daoMethod();
		System.out.println("SERVICE METHOD");
	}

}
