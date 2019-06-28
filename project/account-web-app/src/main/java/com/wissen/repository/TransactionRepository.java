package com.wissen.repository;

import java.util.List;

import com.wissen.model.Transaction;

public interface TransactionRepository {
	
	public void addTransaction(Transaction transaction);
	public List<Transaction> getAllTransaction();
	public List<Transaction> getTransactionByAccount(String accNum);

}
