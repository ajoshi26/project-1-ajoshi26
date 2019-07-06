package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.revature.models.Account;
import com.revature.util.ReimbursementConnectionUtil;

public class AccountRepositoryJDBC implements AccountRepository {
	
	private static final Logger LOGGER = Logger.getLogger(AccountRepositoryJDBC.class);
	
	@Override
	public boolean createAccount(Account account) {
		
		try(Connection connection = ReimbursementConnectionUtil.getConnection()){
			int parameterIndex = 0;
			String query = "INSERT INTO ACCOUNT VALUES (?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement UserStatement = connection.prepareStatement(query);
			
			UserStatement.setLong(++parameterIndex,account.getId());
			UserStatement.setString(++parameterIndex,account.getFirstName());
			UserStatement.setString(++parameterIndex, account.getLastName());
			UserStatement.setString(++parameterIndex, account.getEmail());
			UserStatement.setString(++parameterIndex, account.getUsername());
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

	@Override
	public Account findAccount(long id) {
		LOGGER.trace("Finding Account Information");

		try(Connection connection = ReimbursementConnectionUtil.getConnection()){
			int parameterIndex = 0;
			String sql = "SELECT * FROM ACCOUNT WHERE A_ROLE = 'E' AND A_ID = ?";

			PreparedStatement UserStatement = connection.prepareStatement(sql);
			UserStatement.setLong(++parameterIndex, id);
			
			
			ResultSet result = UserStatement.executeQuery();
			
			if(result.next()) {
				LOGGER.trace("Found Account");
				return new Account(
						result.getLong("A_ID"),
						result.getString("A_FIRST_NAME"),
						result.getString("A_LAST_NAME"),
						result.getString("A_EMAIL"),
						result.getString("A_USERNAME"),
						result.getString("A_PASSWORD"),
						result.getString("A_ROLE"));
			}

		}catch(SQLException e) {
			LOGGER.error("Could not find Account.", e);
		}
		return null;
	}
	

	
}
