package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.DeleteContactImp;

public class Delete extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		DeleteContactImp deleteContactImp = new DeleteContactImp();
		String result = deleteContactImp.deleteContact(id);
		// System.out.println(result);
		HttpSession session = request.getSession();
		session.setAttribute("msg", result);
		response.sendRedirect("readContact.jsp");

	}

}
