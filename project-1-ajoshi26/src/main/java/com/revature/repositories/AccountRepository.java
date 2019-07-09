package com.revature.repositories;

import com.revature.models.Account;

public interface AccountRepository {

	public boolean createAccount(Account account);
	public Account findAccount(Account account);
	public boolean updateAccount(Account account);
}