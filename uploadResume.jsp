



<!-- TOKEN Checking : Session checking-->
<%
      String data= (String)session.getAttribute("adminLogin");
       if(data==null){
    	   response.sendRedirect("adminLogin.jsp");
    	   return;
       }
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="MessegeBox/printMessage.jsp"  %>
      
<form action="UploadResume" method="post" enctype="multipart/form-data">
<input type="file" name="myresume"> <br>
<button>Upload Resume</button>
</form>


</body>
</html>