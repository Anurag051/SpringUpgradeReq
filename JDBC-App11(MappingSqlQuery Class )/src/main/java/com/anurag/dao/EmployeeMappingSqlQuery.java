package com.anurag.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.object.MappingSqlQuery;

import com.anurag.domain.Employee;

public class EmployeeMappingSqlQuery 
extends MappingSqlQuery<Employee>{

	@Override
	protected Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee employee=new Employee();
		employee.setEmpNo(rs.getInt(1));
		employee.setEname(rs.getString(2));
		employee.setSalary(rs.getDouble(3));
		employee.setDeptno(rs.getInt(4));
		employee.setDeptname(rs.getString(5));
		return employee;
	}

	public EmployeeMappingSqlQuery(DataSource ds, String sql) {
		super(ds, sql);
	}

}
