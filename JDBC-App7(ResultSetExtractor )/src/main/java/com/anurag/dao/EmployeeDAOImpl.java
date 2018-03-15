package com.anurag.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.anurag.domain.Employee;

@Repository("empDao")
public class EmployeeDAOImpl implements EmployeeDAO {

	
	@Autowired
	 private JdbcTemplate jdbcTemplate;
	
	public List<Employee> getAllEmployee() {
		String sql="select * from emp02";
		List<Employee>list= jdbcTemplate.query(sql,
				new ResultSetExtractor<List<Employee>>(){

			public List<Employee> extractData(ResultSet rs) 
					throws SQLException, DataAccessException {
				List<Employee>list=new ArrayList<Employee>();
				while (rs.next()) {
					
					Employee employee=new Employee();
					employee.setEmpNo(rs.getInt(1));
					employee.setEname(rs.getString(2));
					employee.setSalary(rs.getDouble(3));
					employee.setDeptno(rs.getInt(4));
					employee.setDeptname(rs.getString(5));
					list.add(employee);	
				}
				return list;
			}//extractData(-);
		});//Query(-)
		return list;
	}//getEmployee(-)
	
	public Employee getEmployee(int empNo){

		Employee employ=null;
		String sql="select * from emp02 where eid=?";
		List<Employee> emp=jdbcTemplate.query
				(sql, new ResultSetExtractor<List<Employee>>(){

					public List<Employee> extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						List<Employee>list=new ArrayList<Employee>();
						while (rs.next()) {
							
							Employee employee=new Employee();
							employee.setEmpNo(rs.getInt(1));
							employee.setEname(rs.getString(2));
							employee.setSalary(rs.getDouble(3));
							employee.setDeptno(rs.getInt(4));
							employee.setDeptname(rs.getString(5));
							list.add(employee);	
						}
						return list;
					}
			
		} //annonmus inner class
		,empNo);//query
		if (emp.size()>0) {
			employ=emp.get(0);
		}
		return employ;
	
	}
}
