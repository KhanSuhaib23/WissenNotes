package com.wissen.service;

import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wissen.Log;
import com.wissen.model.Account;
import com.wissen.model.Transaction;
import com.wissen.model.TransactionType;
import com.wissen.repository.AccountRepository;
import com.wissen.repository.TransactionRepository;

public class NeftTxnService implements TxnService {
	
	private AccountRepository accRepo;
	
	private TransactionRepository txnRepo;
	
	private final static Random r = new Random();
	
	public NeftTxnService(AccountRepository accRepo, TransactionRepository txnRepo) {
		this.accRepo = accRepo;
		this.txnRepo = txnRepo;
	}
	
	@Transactional
	public boolean transfer(String fromAccNum, String toAccNum, double amount) {
		
		Log.ACCOUNT_APP.info("transfering amount : " + amount + " from " + fromAccNum + " to " + toAccNum);
		
		Account fromAccount = accRepo.get(fromAccNum);
		Account toAccount = accRepo.get(toAccNum);
		
		fromAccount.withdrawBalance(amount);
		toAccount.addBalance(amount);
		

		accRepo.update(fromAccount);
		
		Transaction txn = new Transaction(r.nextInt(100000), amount, fromAccount.getBalance(), LocalDateTime.now(), TransactionType.DEBIT, fromAccount);
		
		txnRepo.addTransaction(txn);
		
		accRepo.update(toAccount);
		
		txn = new Transaction(r.nextInt(100000), amount, toAccount.getBalance(), LocalDateTime.now(), TransactionType.CREDIT, toAccount);
		
		txnRepo.addTransaction(txn);
		
		
		return true;
	}

}
