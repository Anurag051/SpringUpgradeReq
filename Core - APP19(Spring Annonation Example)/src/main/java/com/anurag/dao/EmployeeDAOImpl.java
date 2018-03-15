package com.anurag.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.anurag.beans.Employee;


@Repository

public class EmployeeDAOImpl implements EmployeeDAO{
	
	@Autowired
	private DataSource dataSource;

	public int registerEmployee(Employee e) {
		int count=0;
		try {
			Connection connection=dataSource.getConnection();
			PreparedStatement pst=connection.prepareStatement("insert into Employee values(?,?,?)");
			pst.setInt(1, e.getEmpNo());
			pst.setString(2, e.getName());
			pst.setDouble(3, e.getSalary());
			count=pst.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return count;
	}
	
	

}
