package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.revature.models.Account;
import com.revature.util.ReimbursementConnectionUtil;

public class AccountRepositoryJDBC {
	
	private static final Logger LOGGER = Logger.getLogger(AccountRepositoryJDBC.class);
	
	public boolean createAccount(Account account) {
		
		try(Connection connection = ReimbursementConnectionUtil.getConnection()){
			int parameterIndex = 0;
			String query = "INSERT INTO ACCOUNT VALUES (?, ?, ?, ?)";
			
			PreparedStatement UserStatement = connection.prepareStatement(query);
			
			UserStatement.setLong(++parameterIndex,account.getAccount_ID());
			UserStatement.setString(++parameterIndex,account.getUsername());
			UserStatement.setString(++parameterIndex, account.getPassword());
			UserStatement.setString(++parameterIndex, account.getRole());
			
			
			if(UserStatement.executeUpdate() > 0) {
				return true;
			}
			
		}catch(SQLException e) {
			LOGGER.error("Could not create user account.", e);
		}
		
		return false;
	}
	
	public boolean findIDandPassword(String id, String password, String role) {
		LOGGER.trace("Finding Account Information");

		try(Connection connection = ReimbursementConnectionUtil.getConnection()){
			int parameterIndex = 0;
			String sql = "SELECT * FROM ACCOUNT WHERE A_ROLE = 'E'";

			PreparedStatement UserStatement = connection.prepareStatement(sql);
			UserStatement.setString(++parameterIndex, id);
			UserStatement.setString(++parameterIndex, password);
			UserStatement.setString(++parameterIndex, role);
			
			ResultSet result = UserStatement.executeQuery();
			
			if(result.next()) {
				LOGGER.trace("Found Account");
				return true;
			}

		}catch(SQLException e) {
			LOGGER.error("Could not find Account.", e);
		}
		
		
		return false;
	}
	
}
