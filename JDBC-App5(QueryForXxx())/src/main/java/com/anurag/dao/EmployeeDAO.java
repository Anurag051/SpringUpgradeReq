package com.anurag.dao;

import java.util.List;
import java.util.Map;

public interface EmployeeDAO {
	
	public int getDeptNo(int empNo);
	public String getName(int empNo);
	public Double getSalary(int empNo);
	public Map<String, Object>getEmployee(int empNo);
	public List<Map<String, Object>>getAllEmployee();

}
