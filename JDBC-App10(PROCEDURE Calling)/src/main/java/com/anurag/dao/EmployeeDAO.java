package com.anurag.dao;

import java.util.Map;

public interface EmployeeDAO {
	
	public Map<String, Object> callProcedure(int empNo);

}
