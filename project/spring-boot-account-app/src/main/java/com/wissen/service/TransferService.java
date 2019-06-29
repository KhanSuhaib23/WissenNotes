package com.wissen.service;

import org.springframework.stereotype.Service;

public interface TransferService {
	
	public boolean transfer(double amount, String fromAccNum, String toAccNum);

}
