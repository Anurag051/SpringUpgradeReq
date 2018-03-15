package com.anurag.dao;

import java.sql.Types;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Repository;

import com.anurag.domain.Employee;

@Repository("empDao")
public class EmployeeDAOImpl implements EmployeeDAO {

	
	@Autowired
	 private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<Employee> getAllEmployee() {
		String sql="select * from Emp02";
		EmployeeMappingSqlQuery query=new EmployeeMappingSqlQuery(dataSource, sql);
		List<Employee>list=query.execute();
		return list;
	}

	public Employee getEmployee(int empNo) {
		Employee emp=null;
		String sql="select * from Emp02 where eid=?";
		EmployeeMappingSqlQuery query=new EmployeeMappingSqlQuery(dataSource, sql);
		query.declareParameter(new SqlParameter("empno",Types.INTEGER));
		List<Employee>list=query.execute(empNo);
		if (list.size()>0) {
			emp=list.get(0);
		}
		return emp;
	}
	
	
	
}
