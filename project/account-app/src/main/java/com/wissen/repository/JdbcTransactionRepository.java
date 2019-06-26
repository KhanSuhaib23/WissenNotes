package com.wissen.repository;

import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.wissen.model.Transaction;

@Repository("jdbcTransactionRepository")
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

}
