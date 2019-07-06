package com.revature.services;

import com.revature.models.Account;
import com.revature.repositories.AccountRepositoryJDBC;

public class AccountService implements AccountServiceInterface {
	
	private static AccountServiceInterface accountService = new AccountService();
	
	private AccountService() { }
	
	public static AccountServiceInterface getInstance() {
		return accountService;
}

	@Override
	public boolean registerNewAccount(Account account) {
		return AccountRepositoryJDBC.getInstance().createAccount(account);
	}

	@Override
	public Account checkAccount(Account account) {
		Account loggedIn = AccountRepositoryJDBC.getInstance().findAccount(account);
		
		if((loggedIn.getPassword().equals(account.getPassword()) && 
			(loggedIn.getUsername().equals(account.getUsername())))) {
			return loggedIn;
		}
		
		return null;
	}

}
