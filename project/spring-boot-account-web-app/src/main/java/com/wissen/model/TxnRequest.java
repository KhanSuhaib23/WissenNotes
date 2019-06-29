package com.wissen.model;

public class TxnRequest {
	
	private String fromAccNum;
	private String toAccNum;
	private double amount;
	
	public String getFromAccNum() {
		return fromAccNum;
	}
	public void setFromAccNum(String fromAccNum) {
		this.fromAccNum = fromAccNum;
	}
	public String getToAccNum() {
		return toAccNum;
	}
	public void setToAccNum(String toAccNum) {
		this.toAccNum = toAccNum;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double ammount) {
		this.amount = ammount;
	}
	@Override
	public String toString() {
		return "TxnRequest [fromAccNum=" + fromAccNum + ", toAccNum=" + toAccNum + ", amount=" + amount + "]";
	}
	
	
}
