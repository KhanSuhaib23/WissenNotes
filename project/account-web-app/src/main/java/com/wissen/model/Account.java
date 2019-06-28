package com.wissen.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account {
	
	@Id
	@Column(name = "num")
	private String accountNum;
	private double balance;

	public Account() {
		
	}
	
	
	public Account(String accountNum) {
		super();
		this.accountNum = accountNum;
	}

	public String getAccountNum() {
		return accountNum;
	}




	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}




	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void addBalance(double amount) {
		this.balance += amount;
	}
	
	public void withdrawBalance(double amount) {
		this.balance -= amount;
	}

	public String toString() {
		return "Account [accountNum=" + accountNum + ", balance=" + balance + "]";
	}
	
	
		
}
