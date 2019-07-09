package com.revature.controllers;

import javax.servlet.http.HttpServletRequest;

import com.revature.models.Account;
import com.revature.services.AccountService;

public class RegisterController implements RegisterControllerInterface{
	
	private static RegisterControllerInterface registerController = new RegisterController();

	private RegisterController() {}

	public static RegisterControllerInterface getInstance() {
		return registerController;
	}
	
	@Override
	public Object register(HttpServletRequest request) {
			if (request.getMethod().equals("GET")) {
				return "register.html";
			}
			
			Account registeredAccount = new Account(1234,request.getParameter("firstName"),request.getParameter("lastName"),
					request.getParameter("Email"),request.getParameter("username"),request.getParameter("password"),
					request.getParameter("Role"));
			
			if (AccountService.getInstance().registerNewAccount(registeredAccount)){
				return "REGISTRATION SUCCESSFUL";
			} else {
				return "REGISTRATION UNSUCCESSFUL";
	}
			
	}

	@Override
	public Object viewInfo(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object updateInfo(HttpServletRequest request) {
		return  AccountService.getInstance().updateAccount(new Account(0,request.getParameter("firstName"),
				request.getParameter("lastName"),request.getParameter("email"),
				request.getParameter("username"),request.getParameter("password"),request.getParameter("role")));
	}

	@Override
	public Object viewEmployees(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
