package com.anurag.security;

public class AuthorizedManager {
	
	public boolean isAuthorized(String userRole) {
		boolean flag=false;
		if (userRole!=null && userRole.equals("Bank Admin")) {
			return true;
		}
		return flag;
	}

}
