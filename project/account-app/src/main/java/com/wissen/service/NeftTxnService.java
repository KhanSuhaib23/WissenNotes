package com.wissen.service;

import com.wissen.Log;
import com.wissen.model.Account;
import com.wissen.repository.AccountRepository;

public class NeftTxnService implements TxnService {
	
	AccountRepository accRepo;
	
	
	
	public NeftTxnService(AccountRepository accRepo) {
		this.accRepo = accRepo;
	}
	
	public boolean tranfer(String fromAccNum, String toAccNum, double amount) {
		
		Log.ACCOUNT_APP.info("transfering amount : " + amount + " from " + fromAccNum + " to " + toAccNum);
		
		Account fromAccount = accRepo.get(fromAccNum);
		Account toAccount = accRepo.get(toAccNum);
		
//		System.out.println(fromAccount);
//		System.out.println(toAccount);
		fromAccount.withdrawBalance(amount);
		toAccount.addBalance(amount);
		

//		System.out.println(fromAccount);
//		System.out.println(toAccount);
//		
		accRepo.update(fromAccount);
		accRepo.update(toAccount);
		
		return true;
	}

}
