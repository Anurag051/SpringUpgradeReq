package com.anurag.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import com.anurag.domain.Employee;

public class EmployeeDAOImpl implements EmployeeDAO{
	//setting Datasource
private DataSource dataSource;
public void setDataSource(DataSource ds){
this.dataSource=ds;	
}
// Overridden method from interface
public List<Employee> getAllEmployees() {
List<Employee> list=new ArrayList<Employee>();
	try{
Connection con=dataSource.getConnection();
String sql="select empno,ename,sal from employee";
PreparedStatement pst=con.prepareStatement(sql);
ResultSet rs=pst.executeQuery();
while(rs.next()){
//read data from resultset then store into domain obj
   Employee emp=new Employee();
	emp.setEmpno(rs.getInt("empno"));
	emp.setEname(rs.getString("ename"));
	emp.setSal(rs.getDouble("sal"));
//add employee obj into list
	list.add(emp);	
}
	}catch(SQLException se){
System.out.println("Exception Occured "
+ "while searching All Employees ::"+se.getMessage());
	}
		return list;
	}
public Employee getEmployee(int empNo) {
	Employee emp=null;
	try{
	Connection con=dataSource.getConnection();
	String sql="select ename,sal from employee where empNo=?";
	PreparedStatement pst=con.prepareStatement(sql);
	pst.setInt(1,empNo);
	ResultSet rs=pst.executeQuery();
	if(rs.next()){
	emp=new Employee();
	emp.setEmpno(empNo);
	emp.setEname(rs.getString("ename"));
	emp.setSal(rs.getDouble("sal"));
	}
	}catch(SQLException se){
		System.out.println("Exception occured while searching the Employee ::"+se.getMessage());
	}
		return emp;
	}
}
