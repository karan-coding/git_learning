package com.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.service.CreateServiceImp;


public class UploadProject2 extends HttpServlet {
      private  String result;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext servletContext = getServletContext();
		String realPath = servletContext.getRealPath("myProject");
		
		Part part = request.getPart("myfile");
		HttpSession session = request.getSession();
		CreateServiceImp createServiceImp = new CreateServiceImp();
		 result = createServiceImp.insertProjectFile(part,realPath);
		 session.setAttribute("msg", result);
		 response.sendRedirect("uploadProject.jsp");
	}

}
