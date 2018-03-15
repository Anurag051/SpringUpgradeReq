package com.anurag.service;
import java.util.List;
import com.anurag.domain.Employee;

public interface EmployeeService {
	public List<Employee> getAllEmployees();
	public Employee getEmployee(int empNo);

}
