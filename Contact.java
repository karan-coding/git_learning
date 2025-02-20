 package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.ContactDto;
import com.service.CreateServiceImp;

public class Contact extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String message = request.getParameter("message");
		ContactDto contactDto = new ContactDto(name, email, message);
		CreateServiceImp createServiceImp = new CreateServiceImp();
		String result = createServiceImp.insertContact(contactDto);
		//System.out.println(result);
		HttpSession session = request.getSession();
		session.setAttribute("msg", result);
		response.sendRedirect("index.jsp");
	}

}
