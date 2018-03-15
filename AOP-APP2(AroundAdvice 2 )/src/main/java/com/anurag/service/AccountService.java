package com.anurag.service;

public interface AccountService {
	
	int withdraw(int accNo, double amount);
	int deposit(int accNo, double amount);

}
