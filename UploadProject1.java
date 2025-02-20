package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.service.CreateServiceImp;
@MultipartConfig
public class UploadProject1 extends HttpServlet {
	private String result;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Part part = request.getPart("myfile");
		String fileName = part.getSubmittedFileName();
		String fileContant = part.getContentType();
		long fileSize = part.getSize();
		System.out.println(fileName);
		System.out.println(fileContant);
		CreateServiceImp createServiceImp = new CreateServiceImp();
		result = createServiceImp.validateProjectFile(fileName,fileContant, fileSize);
		if (result.equalsIgnoreCase("valid")) {
			//Next  : servlet collab
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("UploadProject2");
			requestDispatcher.forward(request, response);
		}
		else {
			session.setAttribute("msg", result);
			response.sendRedirect("uploadProject.jsp");
		}
	}

}
