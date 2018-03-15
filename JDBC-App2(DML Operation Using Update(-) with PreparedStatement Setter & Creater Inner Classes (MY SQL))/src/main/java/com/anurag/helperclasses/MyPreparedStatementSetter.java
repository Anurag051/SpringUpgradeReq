package com.anurag.helperclasses;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.PreparedStatementSetter;

import com.anurag.domain.Employee;

public class MyPreparedStatementSetter implements PreparedStatementSetter{
	
	 Employee emp;
	
	public MyPreparedStatementSetter(Employee emp) {
		System.out.println("MyPreparedStatementSetter(-) : constructor");
		this.emp = emp;
	}


	public void setValues(PreparedStatement ps) throws SQLException {
		
		System.out.println("setValues(PreparedStatement ps)");
		ps.setInt(1, emp.getEmpNo());
		ps.setString(2, emp.getName());
		ps.setDouble(3, emp.getSalary());
		
	}

}
