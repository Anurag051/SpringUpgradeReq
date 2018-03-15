package com.anurag.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.anurag.domain.Employee;

@Repository("employeeDao")
public class EmployeeDAO extends JdbcDaoSupport {
	
	@Autowired
	public EmployeeDAO(DataSource dataSource) {
		setDataSource(dataSource);
	}

	public int createEmployee(Employee employee) {
		String sql="INSERT INTO EMP VALUES(?,?,?)";
		int count=getJdbcTemplate().update
		(sql, employee.getEmpNo(),employee.getName(),employee.getSalary());
		return count;
	}

}
