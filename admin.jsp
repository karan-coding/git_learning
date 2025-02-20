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
<link href="stylesheet" src="admin.jsp">

<style type="text/css">
     button : hover{
	background-color: blue;
	color: white;
	cursor: pointer;
}

</style>

</head>
<body>
   <a href="readContact.jsp" target="blank"><button>ReadData</button></a> <br> <br>
   <a href="index.jsp" target="blank"><button>MainPage</button></a> <br> <br>
   <a href="uploadProject.jsp" ><button>Upload project</button></a><br><br>
   <a href="uploadResume.jsp"><button>Upload Resume</button></a> <br><br>
   <a href="readAllProject.jsp"><button>Read All Project</button></a><br> <br>
   <a href="addEducation.jsp"><button>Add Education</button></a><br> <br>
   <form action="Logout" method="post">
       <button>Logout</button> 
   </form>
</body>
</html>