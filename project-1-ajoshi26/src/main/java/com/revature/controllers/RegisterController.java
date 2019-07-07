package com.revature.controllers;

import javax.servlet.http.HttpServletRequest;

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
			return request;
	}

}
