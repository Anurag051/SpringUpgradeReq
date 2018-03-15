package com.anurag.service;

import java.util.List;

import com.anurag.dao.EmployeeDAO;
import com.anurag.domain.Employee;

public class EmployeeServiceImpl implements EmployeeService{
	private EmployeeDAO employeeDao;
	
	public void setEmployeeDao(EmployeeDAO employeeDao) {
		this.employeeDao = employeeDao;
	}

	public List<Employee> getAllEmployees() {
		List <Employee> list= employeeDao.getAllEmployees();
		return list;
	}

	public Employee getEmployee(int empNo) {
		Employee emp=employeeDao.getEmployee(empNo);
		return emp;
	}

}
