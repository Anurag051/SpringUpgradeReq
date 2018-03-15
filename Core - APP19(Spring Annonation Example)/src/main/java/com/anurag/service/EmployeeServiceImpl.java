package com.anurag.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anurag.beans.Employee;
import com.anurag.dao.EmployeeDAO;

@Service("empService")

public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeDAO dao;

	public int registerEmployee(Employee e) {
		int count=dao.registerEmployee(e);
		return count;
	}

}
