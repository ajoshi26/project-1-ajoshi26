package com.revature.controllers;

import javax.servlet.http.HttpServletRequest;

public interface RegisterControllerInterface {
	public Object register(HttpServletRequest request);
	public Object updateInfo(HttpServletRequest request);
	public Object viewEmployees(HttpServletRequest request);
	public Object updateRequests(HttpServletRequest request);
}
