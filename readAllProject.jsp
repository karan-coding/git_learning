<%
      String data= (String)session.getAttribute("adminLogin");
       if(data==null){
    	   response.sendRedirect("adminLogin.jsp");
    	   return;
       }
%>

<%@page import="com.Modle.projectFile"%>
<%@page import="java.util.List"%>
<%@page import="com.DAO.ReadContactImp"%>
<%@page import="com.DAO.ReadContact"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="MessegeBox/printMessage.jsp" %>
       <%
					ReadContact readDao=new ReadContactImp();
					List<projectFile> list =  readDao.readProjectFileData();
					for( projectFile file:list){
					%>
					
					
						
								<img style="height: 200px" src="myProject/<%=file.getFileName()%>" class="img-fluid"
									alt="project image">
									<br> 
									<form action="DeleteProjectFile" method="post">
									<input type="hidden" name="filename" value="<%=file.getFileName()%>">
									<button>Delete</button>
									</form>
									<br> <br>
							
						

					<%} %>
</body>
</html>