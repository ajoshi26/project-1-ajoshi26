package com.revature.controllers;

import javax.servlet.http.HttpServletRequest;

import com.revature.models.Account;
import com.revature.repositories.AccountRepository;
import com.revature.repositories.AccountRepositoryJDBC;
import com.revature.services.AccountService;

public class LoginController implements LoginControllerInterface{

	private static LoginControllerInterface loginController = new LoginController();

	private LoginController() {}
	
	public static LoginControllerInterface getInstance() {
		return loginController;
	}
	
	

	
	@Override
	public Object login(HttpServletRequest request) {
		if(request.getMethod().equals("GET")) {
			return "login.html";
		}
		return null;
		
//		Account loggedCustomer = AccountService.getInstance().authenticate(
//					new Account(request.getParameter("username"),
//								 request.getParameter("password"))
//);
	}

	@Override
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "login.html";
	}

	
	

}
