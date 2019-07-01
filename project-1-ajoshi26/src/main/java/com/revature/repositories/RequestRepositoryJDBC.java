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

public class RequestRepositoryJDBC implements RequestRepository {
	
	private static final Logger LOGGER = Logger.getLogger(RequestRepositoryJDBC.class);
	
	@Override
	public boolean insertRequest(Request request) {

		try(Connection connection = ReimbursementConnectionUtil.getConnection()){
			int parameterIndex = 0;
			String query = "INSERT INTO REQUEST VALUES (?, ?, ?, ?, ?)";

			PreparedStatement UserStatement = connection.prepareStatement(query);

			UserStatement.setLong(++parameterIndex, request.getId());
			UserStatement.setString(++parameterIndex, request.getType());
			UserStatement.setLong(++parameterIndex, request.getStatus().getId());
			UserStatement.setLong(++parameterIndex, request.getAccountId());


			if(UserStatement.executeUpdate() > 0) {
				return true;
			}

		}catch(SQLException e) {
			LOGGER.error("Could not create request.", e);
		}

		return false;

	}

	@Override
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
						new Status(result.getLong("S_ID"),result.getString("S_TYPE")),
						result.getLong("A_ID")
						));
			}

			return RequestList;
		} catch (SQLException e) {
			LOGGER.warn("Error on selecting on all the employees", e);
		} 
		return new ArrayList<>();
	}

	@Override
	public List<Request>lookAtRequestByEmployee(Request request){
		try(Connection connection = ReimbursementConnectionUtil.getConnection()) {

			int parameterIndex = 0;
			String sql = "SELECT * FROM REQUEST WHERE A_ID = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setFloat(++parameterIndex,request.getAccountId());
			ResultSet result = statement.executeQuery();

			List<Request> RequestList = new ArrayList<>();
			while(result.next()) {
				RequestList.add(new Request(
						result.getLong("R_ID"),
						result.getString("R_TYPE"),
						new Status(result.getLong("R_ID"), result.getString("R_TYPE")),
						result.getLong("A_ID")
						));
			}

			return RequestList;
		} catch (SQLException e) {
			LOGGER.warn("Error on selecting on all the employees", e);
		} 
		return new ArrayList<>();
	}
	
	@Override
	public void approveOrDeny (Request request, boolean checkForApproval) {

	}


}
