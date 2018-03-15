package com.anurag.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.anurag.domain.Employee;

@Repository("empDao")
public class EmployeeDAOImpl implements EmployeeDAO {

	
	@Autowired
	 private JdbcTemplate jdbcTemplate;
	
	public List<Employee> getAllEmployee() {
		String sql="select eid,ename,sal from emp01";
		List<Employee>list=jdbcTemplate.query(sql, new RowMapper<Employee>(){

			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee employee= new Employee();
				employee.setEmpNo(rs.getInt("eid"));
				employee.setEname(rs.getString("ename"));
				employee.setSalary(rs.getFloat("sal"));
				return employee;
			}//maprow
			
		} //annonmus inner class
		);//query
		
		return list;
	}	
	
	public Employee getEmployee(int empNo){

		Employee employ=null;
		String sql="select eid,ename,sal from emp01 where eid=?";
		List<Employee> emp=jdbcTemplate.query(sql, new RowMapper<Employee>(){

			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee employee= new Employee();
				employee.setEmpNo(rs.getInt("eid"));
				employee.setEname(rs.getString("ename"));
				employee.setSalary(rs.getFloat("sal"));
				return employee;
			}//maprow
			
		} //annonmus inner class
		,empNo);//query
		if (emp.size()>0) {
			employ=emp.get(0);
		}
		return employ;
	
	}
}
