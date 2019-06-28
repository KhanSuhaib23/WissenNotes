package com.wissen.service;

import java.util.List;

import com.wissen.model.Transaction;

public interface TxnService {

	public boolean transfer(String fromAccNum, String toAccNum, double amount);
	public List<Transaction> getTransactionByAccNum(String accNum);
}
