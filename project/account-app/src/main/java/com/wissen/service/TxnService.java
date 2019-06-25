package com.wissen.service;

public interface TxnService {

	public boolean tranfer(String fromAccNum, String toAccNum, double amount);
	
}
