<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js" ></script>
<script type="text/javascript" src="index.js"></script> 

<title>Student Home</title>
</head>
<body>
<%
if(request.getAttribute("id")==null){
	response.sendRedirect("student.jsp");
}

%>
<center>
<h1>Welcome, <i>${name}</i></h1>
<table bgcolor="lightblue">
<tr><td><b>Student id<b><td>:<td>${id}</td></tr>
<tr><td><b>Name<b><td>:<td>${name}</td></tr>
<tr><td><b>Dept<b><td>:<td>${dept}</td></tr>
<tr><td><b>City<b><td>:<td>${city}</td></tr>
</table><br><br>
<input type="text" id="sid" value="${id}" hidden>
<button id="showresult">Result</button>
<br><br>
<table border="1px" id="resulttable">

</table>
</center>

</body>
</html>