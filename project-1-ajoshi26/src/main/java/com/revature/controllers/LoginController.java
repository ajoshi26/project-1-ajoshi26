package com.revature.controllers;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.revature.models.Account;
import com.revature.repositories.AccountRepositoryJDBC;
import com.revature.services.AccountService;

public class LoginController implements LoginControllerInterface{

	private static LoginControllerInterface loginController = new LoginController();
	private static final Logger LOGGER = Logger.getLogger(LoginController.class);

	private LoginController() {}
	
	public static LoginControllerInterface getInstance() {
		return loginController;
	}
	
	
	@Override
	public Object login(HttpServletRequest request) {
		if(request.getMethod().equals("GET")) {
			return "login.html";
		}
		
		
		Account loggedIn = AccountService.getInstance().checkAccount(new Account(0,null,null,
				null,request.getParameter("username"),request.getParameter("password"),
				request.getParameter("role")));
		
		LOGGER.trace("About to login in...");
		
		if(loggedIn == null) {
			LOGGER.warn("Could not login");
			return "AUTHENTICATION_FAILED";
		}
		
		LOGGER.info("Login Successful!");
		request.getSession().setAttribute("loggedIn", loggedIn);
		
		if(request.getParameter("role") == "M") {
			return "Manager.html";
		}
		else if(request.getParameter("role") == "E") {
			return "Employee.html";
		}
			
			
		return loggedIn;
		
	}
	
	@Override
	public Object update(HttpServletRequest request) {
		return  AccountService.getInstance().updateAccount(new Account(0,request.getParameter("firstName"),
				request.getParameter("lastName"),request.getParameter("email"),
				request.getParameter("username"),request.getParameter("password"),request.getParameter("role")));
	}

	@Override
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "login.html";
	}



	
	

}
