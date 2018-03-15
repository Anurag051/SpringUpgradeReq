package com.anurag.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component("service")
public class EmployeeService {
	private EmployeeDAO dao;
	@Autowired
	public void setDao(EmployeeDAO dao) {
		this.dao = dao;
	}
	public void serviceMethod() {
		dao.daoMethod();
		System.out.println("EmployeeService Class => ServiceMethod");
	}

}
