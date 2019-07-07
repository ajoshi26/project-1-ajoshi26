package com.revature.request;
import javax.servlet.http.HttpServletRequest;

import com.revature.controllers.HomeController;
import com.revature.controllers.LoginController;
import com.revature.controllers.RegisterController;

public class RequestHelper {

	private RequestHelper() {}

	public static Object process(HttpServletRequest request) {
		switch(request.getRequestURI()) {
		case "/project-1-ajoshi26/login.do":
			return LoginController.getInstance().login(request);
		case "/project-1-ajoshi26/logout.do":
			return LoginController.getInstance().logout(request);
		case "/project-1-ajoshi26/home.do":
			return HomeController.getInstance().home(request);
		case "/project-1-ajoshi26/register.do":
			return RegisterController.getInstance().register(request);
		default:
			return "404";
		}
	}
}
