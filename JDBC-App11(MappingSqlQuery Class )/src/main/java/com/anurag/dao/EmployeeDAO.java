package com.anurag.dao;

import java.util.List;

import com.anurag.domain.Employee;

public interface EmployeeDAO {
	
	public List<Employee>getAllEmployee();
	public Employee getEmployee(int empNo);
	
}
