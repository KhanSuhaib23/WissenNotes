package com.wissen.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wissen.model.Account;
import com.wissen.model.Transaction;
import com.wissen.model.TransactionType;
import com.wissen.repository.AccountRepository;
import com.wissen.repository.TransactionRepository;

@Service ("txnService")
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
		
		
		Account fromAccount = accRepo.findById(fromAccNum).get();
		Account toAccount = accRepo.findById(toAccNum).get();
		
		fromAccount.withdrawBalance(amount);
		toAccount.addBalance(amount);
		

		accRepo.save(fromAccount);
		
		Transaction txn = new Transaction(r.nextInt(100000), amount, fromAccount.getBalance(), LocalDateTime.now(), TransactionType.DEBIT, fromAccount);
		
		txnRepo.save(txn);
		
		accRepo.save(toAccount);
		
		txn = new Transaction(r.nextInt(100000), amount, toAccount.getBalance(), LocalDateTime.now(), TransactionType.CREDIT, toAccount);
		
		txnRepo.save(txn);
		
		
		return true;
	}
	
	public List<Transaction> getTransactionByAccNum(String accNum) {
		return txnRepo.getByAccountNum(accNum);
	}

}
