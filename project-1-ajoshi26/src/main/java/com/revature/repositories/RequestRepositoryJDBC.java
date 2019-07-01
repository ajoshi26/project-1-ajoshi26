package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.Account;
import com.revature.models.Request;
import com.revature.models.Status;
import com.revature.util.ReimbursementConnectionUtil;

public class RequestRepositoryJDBC {
	
	private static final Logger LOGGER = Logger.getLogger(RequestRepositoryJDBC.class);
	
	public boolean insertRequest(Request request) {
		
		try(Connection connection = ReimbursementConnectionUtil.getConnection()){
			int parameterIndex = 0;
			String query = "INSERT INTO REQUEST VALUES (?, ?, ?, ?, ?)";
			
			PreparedStatement UserStatement = connection.prepareStatement(query);
			
			UserStatement.setLong(++parameterIndex, request.getRequest_ID());
			UserStatement.setString(++parameterIndex, request.getType());
			UserStatement.setString(++parameterIndex, request.getStatus());
			UserStatement.setLong(++parameterIndex, request.getAccount_ID());
			UserStatement.setLong(++parameterIndex, request.getStatus_ID());
			
			
			if(UserStatement.executeUpdate() > 0) {
				return true;
			}
			
		}catch(SQLException e) {
			LOGGER.error("Could not create request.", e);
		}
		
		return false;
		
	}
	
	public List<Request> lookAtRequest(){
		try(Connection connection = ReimbursementConnectionUtil.getConnection()) {
			String command = "SELECT * FROM REQUEST";
			PreparedStatement statement = connection.prepareStatement(command);
			ResultSet result = statement.executeQuery();

			List<Request> RequestList = new ArrayList<>();
			while(result.next()) {
				RequestList.add(new Request(
						result.getLong("R_ID"),
						result.getString("R_TYPE"),
						result.getString("R_STATUS"),
						result.getDouble("R_AMOUNT"),
						result.getLong("A_ID"),
						result.getLong("S_ID")
						));
			}

			return RequestList;
		} catch (SQLException e) {
			LOGGER.warn("Error on selecting on all the employees", e);
		} 
		return new ArrayList<>();
	}

	public List<Request> lookAtRequestByEmployee(Account account){
		return null;
	}
	
	public void approveOrDeny (Request request, boolean checkForApproval) {
		
	}
	

}
