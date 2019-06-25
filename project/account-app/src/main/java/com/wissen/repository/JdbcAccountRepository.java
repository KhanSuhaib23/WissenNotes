package com.wissen.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.wissen.Log;
import com.wissen.model.Account;

public class JdbcAccountRepository implements AccountRepository {
	
	private DataSource dataSource;
	
	public JdbcAccountRepository(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public Account get(String accNum) {
		
		Log.ACCOUNT_APP.info("Getting account : " + accNum);
		
		Account acc = new Account();
		
		try {
			Connection conn = dataSource.getConnection();
			String sql = "select * from account where num = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, accNum);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				String number = rs.getString(1);
				double balance = rs.getDouble(2);
				
				acc.setAccountNum(number);
				acc.setBalance(balance);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return acc;
	}

	@Override
	public boolean update(Account account) {
		
		Log.ACCOUNT_APP.info("Updating account : " + account.getAccountNum() + " , Balance : " + account.getBalance());
		
		boolean ret = false;
		
		try {
			Connection conn = dataSource.getConnection();
			String sql = "update account set balance=? where num=?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setDouble(1, account.getBalance());
			ps.setString(2, account.getAccountNum());
			
			int res = ps.executeUpdate();
			
			ret = res == 1;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}

	
	
}
