package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.EducationDto;
import com.service.CreateServiceImp;

public class Education extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title = request.getParameter("title");
		String subtitle = request.getParameter("subtitle");
		String year = request.getParameter("year");
		String Description = request.getParameter("Description");
		EducationDto educationDto = new EducationDto(title, subtitle, year, Description);
		  CreateServiceImp createServiceImp = new CreateServiceImp();
		  String result = createServiceImp.insertEducationService(educationDto);
		  HttpSession session = request.getSession();
		  session.setAttribute("msg", result);
		  response.sendRedirect("addEducation.jsp");
		
		
		
	}

}
