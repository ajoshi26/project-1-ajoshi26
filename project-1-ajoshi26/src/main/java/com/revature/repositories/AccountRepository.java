package com.revature.repositories;

import com.revature.models.Account;

public interface AccountRepository {

	public boolean createAccount(Account account);
	public boolean findUserNameAndPassword(String id, String password);
	
}