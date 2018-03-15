package com.anurag.service;

import com.anurag.beans.Employee;
import com.anurag.dao.EmployeeDAO;

public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeDAO empdao;

	public EmployeeDAO getEmpdao() {
		return empdao;
	}

	public void setEmpdao(EmployeeDAO empdao) {
		this.empdao = empdao;
	}

	public Employee searchEmployee(int empno) {
		Employee emp =empdao.searchEmployee(empno);
		return emp;
	}

}
