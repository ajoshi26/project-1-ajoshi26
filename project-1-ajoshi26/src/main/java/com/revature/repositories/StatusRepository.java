package com.revature.repositories;

import java.util.List;

import com.revature.models.Request;
import com.revature.models.Status;

public interface StatusRepository {
	public boolean insertStatus(Status status);
	public List<Status> getStatus();
}
