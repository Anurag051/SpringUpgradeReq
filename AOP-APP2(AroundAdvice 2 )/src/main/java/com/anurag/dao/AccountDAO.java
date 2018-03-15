package com.anurag.dao;

public interface AccountDAO {

	double getBalance(int accNo);

	int setBalance(int accNo, double totalBalance);

}
