
<%
      String data= (String)session.getAttribute("adminLogin");
       if(data==null){
    	   response.sendRedirect("adminLogin.jsp");
    	   return;
       }
%>
<!DOCTYPE html>
<%@page import="com.Modle.BindData"%>
<%@page import="java.util.List"%>
<%@page import="com.DAO.ReadContactImp"%>
<%@page import="com.DAO.ReadContact"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- Read all contact -->
	<%@ include file="MessegeBox/printMessage.jsp"  %>   
	
	<%
	ReadContact read = new ReadContactImp();
	List<BindData> list=read.readeContact();/* call readContact() method by read object for get list object(collection of data)  */
	int sn=1;
	for(BindData getdata:list) {  /* get data one by one from list */
	%>

    <h4>SN: <%=sn %></h4>
	<%-- <h4>Name:<%=data.getName() %></h4>
	<h4>Email:<%=data.getEmail() %></h4>
	<h4>Message:<%=data.getMessage() %></h4> <!-- print data on web page -->
	<h4>DateTime:<%=data.getDatetime() %></h4> --%>
	<label>Name </label>
	<input placeholder="Usernae" value="<%=getdata.getName() %>"> <br>
	<label>Email Id </label>
	<input placeholder="Usernae" value="<%=getdata.getEmail() %>"> <br>
	<label>Message </label>
	<input placeholder="Usernae" value="<%=getdata.getMessage() %>"> <br>
	<label>Date Time </label>
	<input placeholder="Usernae" value="<%=getdata.getDatetime() %>"> <br>
	<form action="Delete" method="post">
	<input type="hidden" name="id" value="<%=getdata.getId()%>">
	<button>Delete</button>
	</form>	
	<form action="Edit" method="post">
	<input type="hidden" name="id" value="<%=getdata.getId()%>">
	<button>Edit</button>
	</form>	
	<%
	sn++;
	}
	%>

</body>
</html>