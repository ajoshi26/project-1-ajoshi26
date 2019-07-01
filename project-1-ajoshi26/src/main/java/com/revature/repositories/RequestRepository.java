package com.revature.repositories;

import java.util.List;
import java.util.ArrayList;
import com.revature.models.*;

public interface RequestRepository  {
	
	public boolean insertRequest(Request request);
	public List<Request> lookAtRequest();
	public List<Request> lookAtRequestByEmployee(Account account);
	public void approveOrDeny (Request request, boolean checkForApproval);
	
}
