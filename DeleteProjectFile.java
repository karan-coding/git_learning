package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.DeleteContactImp;

public class DeleteProjectFile extends HttpServlet {
	
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filename = request.getParameter("filename");
		DeleteContactImp deleteContactImp = new DeleteContactImp();
		String result = deleteContactImp.projectFileDeleteService(filename);
		HttpSession session = request.getSession();
		session.setAttribute("msg", result);
		response.sendRedirect("readAllProject.jsp");
	}

}
