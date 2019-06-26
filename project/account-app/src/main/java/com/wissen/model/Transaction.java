package com.wissen.model;

import java.time.LocalDateTime;

public class Transaction {
	
	private int id;
	private double amount;
	private double closingBalance;
	private LocalDateTime dataTime;
	private TransactionType type;
	String accNum;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getClosingBalance() {
		return closingBalance;
	}
	public void setClosingBalance(double closingBalance) {
		this.closingBalance = closingBalance;
	}
	public LocalDateTime getDataTime() {
		return dataTime;
	}
	public void setDataTime(LocalDateTime dataTime) {
		this.dataTime = dataTime;
	}
	public TransactionType getType() {
		return type;
	}
	public void setType(TransactionType type) {
		this.type = type;
	}
	public Transaction(int id, double amount, double closingBalance, LocalDateTime dataTime, TransactionType type,
			String accNum) {
		super();
		this.id = id;
		this.amount = amount;
		this.closingBalance = closingBalance;
		this.dataTime = dataTime;
		this.type = type;
		this.accNum = accNum;
	}
	public String getAccNum() {
		return accNum;
	}
	public void setAccNum(String accNum) {
		this.accNum = accNum;
	}
	
	
}
