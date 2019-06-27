package com.wissen.repository;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.wissen.model.Account;

@Repository("jdbcAccountRepository")
@Qualifier("jdbc")
public class JdbcAccountRepository implements AccountRepository {
	
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcAccountRepository(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public Account get(String accNum) {
		
		Account acc = new Account();
		
		String sql = "select * from account where num=?";
		
		jdbcTemplate.queryForObject(sql, (rs, rn) -> {
			
				acc.setAccountNum(rs.getString(1));
				acc.setBalance(rs.getDouble(2));
			
			return acc;
		}, accNum);
		
		
		return acc;
	}

	@Override
	public boolean update(Account account) {
		
		String sql = "update account set balance=? where num=?";
		
		jdbcTemplate.update(sql, account.getBalance(), account.getAccountNum());
		
		return true;
	}

	
	
}
