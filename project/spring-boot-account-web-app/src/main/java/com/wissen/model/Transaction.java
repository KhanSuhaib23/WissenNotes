package com.wissen.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")
public class Transaction {
	
	@Id
	private int id;
	
	private double amount;
	
	@Column(name = "closing_balance")
	private double closingBalance;
	
	@Column(name = "date_time")
	private LocalDateTime dataTime;
	
	@Enumerated (EnumType.STRING)
	private TransactionType type;
	
	@ManyToOne
	@JoinColumn (name = "acc_num")
	private Account account;
	
	
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
			Account account) {
		super();
		this.id = id;
		this.amount = amount;
		this.closingBalance = closingBalance;
		this.dataTime = dataTime;
		this.type = type;
		this.account = account;
	}
	
	public Transaction() {
		
	}
	public Account getAccNum() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	@Override
	public String toString() {
		return "Transaction [id=" + id + ", amount=" + amount + ", closingBalance=" + closingBalance + ", dataTime="
				+ dataTime + ", type=" + type + ", account=" + account + "]";
	}
	
	
}
