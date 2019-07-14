package com.revature.controllers;

import javax.servlet.http.HttpServletRequest;

import com.revature.models.Account;
import com.revature.models.Request;
import com.revature.services.AccountService;
import com.revature.services.RequestService;

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
			
			Account registeredAccount = new Account(request.getParameter("firstName"),request.getParameter("lastName"),
					request.getParameter("Email"),request.getParameter("username"),request.getParameter("password"),
					request.getParameter("Role"));
			
			if (AccountService.getInstance().registerNewAccount(registeredAccount)){
				
				if(request.getParameter("role").equals("M")) {
					return HomeController.getInstance().ManagerHome(request);
				}
				else if(request.getParameter("role").equals("E")) {
					return HomeController.getInstance().EmployeeHome(request);
				}
				
			} else {
				return "REGISTRATION UNSUCCESSFUL";
			}
	 return null;
	}
			

	@Override
	public Object updateInfo(HttpServletRequest request) {
		return  AccountService.getInstance().updateAccount(new Account(request.getParameter("firstName"),
				request.getParameter("lastName"),request.getParameter("email"),
				request.getParameter("username"),request.getParameter("password"),request.getParameter("role")));
	}

	@Override
	public Object viewEmployees(HttpServletRequest request) {
		return AccountService.getInstance().viewAccount();
	}

	@Override
	public Object insertRequests(HttpServletRequest request) {
		return RequestService.getInstance().insertingRequests(new Request(request.getParameter("requestType")));
	}


}
