package com.wissen.repository;

import com.wissen.model.Account;

public interface AccountRepository {
	
	public Account get(String accNum);
	
	public boolean update(Account account);
	
}
