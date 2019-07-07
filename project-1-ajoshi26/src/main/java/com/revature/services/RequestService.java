package com.revature.services;

import java.util.List;

import com.revature.models.Request;
import com.revature.repositories.RequestRepositoryJDBC;

public class RequestService implements RequestServiceInterface{

	@Override
	public List<Request> listAllRequests() {
		return RequestRepositoryJDBC.getInstance2().lookAtRequest();
	}

	@Override
	public boolean insertingRequests(Request request) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
