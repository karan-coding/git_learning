package com.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




public class DownloadResume extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//FIS(realPath
		//byteArray
		//write on browser
		ServletContext servletContext = getServletContext();
		String realPath = servletContext.getRealPath("myresume");
		FileInputStream fileInputStream = new FileInputStream(realPath+File.separator+"resume_karan.pdf");
		byte[] b = fileInputStream.readAllBytes();
		ServletOutputStream outputStream = response.getOutputStream();
		response.setHeader("content-disposition", "filename=karan_resume.pdf");
		response.setContentType("application/octet-stream");
		outputStream.write(b);
	}

}
