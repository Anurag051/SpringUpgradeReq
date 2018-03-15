package com.anurag.dao;

import com.anurag.domain.Employee;

public interface EmployeeDAO {
	
	public int createEmployee(Employee employee);
	public int deleteEmployee(int empNO);
	public int updateEmployee(int empNO,String name);

}
