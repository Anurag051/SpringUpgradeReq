package com.anurag.dao;

import java.sql.Types;

import org.springframework.jdbc.core.JdbcTemplate;

import com.anurag.domain.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int createEmployee(Employee employee) {
		String sql="INSERT INTO EMP VALUES(?,?,?)";
		int count=jdbcTemplate.update
		(sql, employee.getEmpNo(),employee.getName(),employee.getSalary());
		return count;
	}

	public int deleteEmployee( int empNO) {
		String sql="DELETE FROM EMP WHERE EID = ?";
		int count=jdbcTemplate.update(sql, new Object[]{empNO},new int[] {Types.INTEGER} );	
		return count;
	}

	public int updateEmployee( int empNO,  String name) {
		
		String sql="UPDATE EMP SET ENAME=? WHERE EID = ?";
		int count=jdbcTemplate.update
					(sql,new Object[]{name,empNO},new int[]{Types.VARCHAR,Types.INTEGER});	
		return count;
			
	}

}
