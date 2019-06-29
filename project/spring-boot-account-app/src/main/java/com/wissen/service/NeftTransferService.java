package com.wissen.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wissen.model.Account;
import com.wissen.repository.AccountRepository;

@Service("transferService")
public class NeftTransferService implements TransferService {

	@Autowired
	AccountRepository accountRepo;
	
	@Transactional
	@Override
	public boolean transfer(double amount, String fromAccNum, String toAccNum) {
		
		Account fromAcc = accountRepo.findById(fromAccNum).get();
		Account toAcc = accountRepo.findById(toAccNum).get();
		
		fromAcc.setBalance(fromAcc.getBalance() - amount);
		toAcc.setBalance(toAcc.getBalance() + amount);
		
		accountRepo.save(fromAcc);
		accountRepo.save(toAcc);
		
		return true;
	}

}
