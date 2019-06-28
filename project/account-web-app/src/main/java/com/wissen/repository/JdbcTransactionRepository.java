package com.wissen.repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.wissen.model.Transaction;

@Repository("jdbcTransactionRepository")
@Qualifier("jdbc")
public class JdbcTransactionRepository implements TransactionRepository {

	JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcTransactionRepository(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void addTransaction(Transaction transaction) {
		
		String sql = "insert into transaction values(?, ?, ?, ?, ?, ?)";
		
		jdbcTemplate.update(sql, transaction.getId(), transaction.getAmount(), transaction.getClosingBalance(), transaction.getDataTime().toString(), transaction.getType().name(), transaction.getAccNum());
		
	}

	@Override
	public List<Transaction> getAllTransaction() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transaction> getTransactionByAccount(String accNum) {
		// TODO Auto-generated method stub
		return null;
	}

}
