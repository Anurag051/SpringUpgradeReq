package com.anurag.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.DataSource;
import com.anurag.beans.Employee;

public class EmployeeDAOImpl implements EmployeeDAO{
	
	private DataSource dataSource;
	

	public DataSource getDataSource() {
		return dataSource;
	}


	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}


	public Employee searchEmployee(int empno) {
		Employee emp=null;
		Connection con=null;
		ResultSet rs=null;
		PreparedStatement pst=null;
		try{
			System.out.println("Start Point searchEmployee()");
			con= dataSource.getConnection();
			System.out.println("Connection Object Initallaized");
			if(con!=null){
			pst=con.prepareStatement
					("SELECT EMPNO,ENAME,SAL FROM EMPLOYEE WHERE EMPNO = ?");
			System.out.println("Prepared Statement  Object Initallaized");
			pst.setInt(1, empno);
			}
			if(pst!=null){
			rs=pst.executeQuery();
			System.out.println("Query Executed ResultSet Obtained");
			}
			if(rs!=null && rs.next()){
				System.out.println("ResultSet Data Extration Started");
				emp=new Employee();
				emp.setEmpno(rs.getInt(1));
				emp.setEname(rs.getString(2));
				emp.setSalary(rs.getDouble(3));
				System.out.println("ResultSet Data Extracted & stored in Employee object");
			}
			}catch(Exception e){
				System.out.println("Exception occured while serachEmployee() : "+e.toString());
			}finally{
				if(rs !=null){
					try{
						rs.close();
					}catch(Exception e){
						System.out.println("Exception occured while closing ResultSet "+e.getMessage());
					}
				}
				if(pst !=null){
					try{
						pst.close();
					}catch(Exception e){
						System.out.println("Exception occured while closing Prepared Statement "+e.getMessage());
					}
				}
				if(con !=null){
					try{
						con.close();
					}catch(Exception e){
						System.out.println("Exception occured while closing Connection "+e.getMessage());
					}
				}
			}
		return emp;
	}

}
