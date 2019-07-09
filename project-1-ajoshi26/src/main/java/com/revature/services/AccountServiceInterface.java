package com.revature.services;

import com.revature.models.Account;

public interface AccountServiceInterface {
	
	public boolean registerNewAccount(Account account);
	public Account checkAccount (Account account);
	public boolean updateAccount (Account account);

}
