package com.revature.services;

import java.util.List;

import com.revature.models.Request;

public interface RequestServiceInterface {
	
	public List<Request> listAllRequests();
	public boolean insertingRequests(Request request);
}
