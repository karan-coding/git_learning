<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <form action="Login" method="post">
   <input type="text" name="username" placeholder="Enter User Name max 16 & min 5"> <br>
   <input type="password" name="password" placeholder="Enter your password max 16 & min 5"> <br>
   <button>Login</button>
   
   
   </form>
   
   <%@ include file="MessegeBox/printMessage.jsp" %>
</body>
</html>