package com.anurag.beans;

public class Service {
	private DAO dao;

	public DAO getDao() {
		return dao;
	}

	public void setDao(DAO dao) {
		this.dao = dao;
	}
	public void serviceMethod() {
		dao.daoMethod();
		System.out.println("SERVICE METHOD");
	}
	
}
