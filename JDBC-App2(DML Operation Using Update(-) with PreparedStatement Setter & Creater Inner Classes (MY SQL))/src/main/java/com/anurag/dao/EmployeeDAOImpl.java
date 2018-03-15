package com.anurag.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.anurag.domain.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	private JdbcTemplate jdbcTemplate;

	
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	//using Inner Classes
	public int createEmployee(final Employee employee) {
		String sql="INSERT INTO EMP VALUES(?,?,?)";
		int count=jdbcTemplate.update(sql, new PreparedStatementSetter() {
			
			public void setValues(PreparedStatement ps) throws SQLException {
				
				ps.setInt(1, employee.getEmpNo());
				ps.setString(2, employee.getName());
				ps.setDouble(3, employee.getSalary());
				
			}
		});
		return count;
	}
	//Using Inner Classes
	public int deleteEmployee(final int empNO) {
		String sql="DELETE FROM EMP WHERE EID = ?";
		int count=jdbcTemplate.update(sql, new PreparedStatementSetter() {
			
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, empNO);
				
			}
		});
		return count;
	}
	//Using Inner Classes
	public int updateEmployee(final int empNO, final String name) {
		
		
		int count=jdbcTemplate.update(new PreparedStatementCreator() {
			
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String sql="UPDATE EMP SET ENAME=? WHERE EID=?";
				PreparedStatement pst=con.prepareStatement(sql);
				pst.setString(1, name);
				pst.setInt(2, empNO);
				return pst;
			}
		});
		return count;
	}

}
