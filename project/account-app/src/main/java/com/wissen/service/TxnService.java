package com.wissen.service;

public interface TxnService {

	public boolean transfer(String fromAccNum, String toAccNum, double amount);
	
}
