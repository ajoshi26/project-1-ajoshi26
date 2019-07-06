package com.revature.repositories;

import com.revature.models.Account;

public interface AccountRepository {

	public boolean createAccount(Account account);
	public Account findAccount(long id);
	
}