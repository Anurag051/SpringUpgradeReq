package com.anurag.dao;

import com.anurag.domain.Employee;

public interface EmployeeDAO {
	
	public int createEmployee(Employee employee);
	public Employee getEmployee(int empNo);

}
