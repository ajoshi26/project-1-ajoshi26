package com.revature.repositories;

import java.util.List;
import java.util.ArrayList;
import com.revature.models.*;
import com.revature.util.ReimbursementConnectionUtil;

public interface RequestRepository  {
	
	public boolean insertRequest(Request request);
	public List<Request> lookAtRequest();
	public Request lookAtRequestByEmployee(long rID);
	public boolean updateRequest (Request request);
	
}
