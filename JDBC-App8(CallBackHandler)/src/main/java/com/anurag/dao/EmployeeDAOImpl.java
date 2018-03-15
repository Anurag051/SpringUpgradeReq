package com.anurag.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.anurag.domain.Employee;

@Repository("empDao")
public class EmployeeDAOImpl implements EmployeeDAO {

	
	@Autowired
	 private JdbcTemplate jdbcTemplate;
	
	public List<Employee> getAllEmployee() {
		final List<Employee>list=new ArrayList<Employee>();
		String sql="select eid,ename,sal from emp01";
		jdbcTemplate.query(sql, new RowCallbackHandler() {
			
			public void processRow(ResultSet rs) throws SQLException {
				Employee employee= new Employee();
				employee.setEmpNo(rs.getInt("eid"));
				employee.setEname(rs.getString("ename"));
				employee.setSalary(rs.getFloat("sal"));
				list.add(employee);
			}
		});
		return list;
	}	
	
	public Employee getEmployee(int empNo){

		final Employee employee= new Employee();
		String sql="select eid,ename,sal from emp01 where eid=?";
		jdbcTemplate.query(sql, new RowCallbackHandler() {
			
			public void processRow(ResultSet rs) throws SQLException {
				
				employee.setEmpNo(rs.getInt("eid"));
				employee.setEname(rs.getString("ename"));
				employee.setSalary(rs.getFloat("sal"));
			}
		},empNo);
		return employee;
	}
}
