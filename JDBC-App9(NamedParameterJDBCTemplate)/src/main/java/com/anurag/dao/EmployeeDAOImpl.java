package com.anurag.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.anurag.domain.Employee;

@Repository("empDao")
public class EmployeeDAOImpl implements EmployeeDAO {

	
	@Autowired
	 private NamedParameterJdbcTemplate jdbcTemplate;
	
	public Employee getEmployee(int empNo){
		

		final Employee employee= new Employee();
		String sql="select eid,ename,sal from emp03 where eid="+empNo;
	
		jdbcTemplate.query(sql, new RowCallbackHandler() {
			
			public void processRow(ResultSet rs) throws SQLException {
				
				employee.setEmpNo(rs.getInt("eid"));
				employee.setEname(rs.getString("ename"));
				employee.setSalary(rs.getFloat("sal"));
			}
		});
		return employee;
	}
		


	public int createEmployee(Employee employee) {
		
		String sql="insert into emp03 values(:empNo,:ename,:salary)";
		Map<String, Object>map=new HashMap<String, Object>();
		map.put("empNo",employee.getEmpNo());
		map.put("ename", employee.getEname());
		map.put("salary", employee.getSalary());
		int count = jdbcTemplate.update(sql, map);
		return count;
	}
}
