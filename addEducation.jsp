
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

        <%@ include file="MessegeBox/printMessage.jsp"%>
       
    <form action="Education" method="post">
      <input type="text" name="title" placeholder="Enter Title"> <br>
       <input type="text" name="subtitle" placeholder="Enter subtitle"> <br>
        <input type="text" name="year" placeholder="Enter year"> <br>
         <input type="text" name="Description" placeholder="Enter Descripation"> <br>
          <button>Add Education</button>
    </form>
</body>
</html>