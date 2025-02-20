package com.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.service.CreateServiceImp;
@MultipartConfig
public class UploadResume extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Part part = request.getPart("myresume");
		ServletContext servletContext = getServletContext();
		String realPath = servletContext.getRealPath("myresume");
		CreateServiceImp createServiceImp = new CreateServiceImp();
		String result = createServiceImp.insertResume(part, realPath);
		
		session.setAttribute("msg",result );
		
		response.sendRedirect("uploadResume.jsp");
		
		
	}

}
