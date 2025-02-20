package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;
import com.service.LoginService;

public class Login extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		LoginService loginService = new LoginService();
		String result = loginService.LoginService(username, password);
		if (result.equalsIgnoreCase("EXIST")) {
			session.setAttribute("adminLogin", username);
			response.sendRedirect("admin.jsp");
		}
		else {
			session.setAttribute("msg", result);
			response.sendRedirect("adminLogin.jsp");
		}
	}

}
