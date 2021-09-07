<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js" ></script>
<script type="text/javascript" src="index.js"></script> 

<title>Student Home</title>
<style>
#resulttable {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 50%;
}

#resulttable td, #resulttable th {
  border: 1px solid #ddd;
  padding: 8px;
}

#resulttable tr:nth-child(even){background-color: #f2f2f2;}

#resulttable tr:hover {background-color: #ddd;}

#resulttable th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #04AA6D;
  color: white;
}
</style>
</head>
<body>
<%
if(request.getAttribute("sid")==null){
	response.sendRedirect("student.jsp");
}

%>
<center>
<h1>Welcome, <i>${studentdetail.get(0).name}</i></h1>
<table bgcolor="lightblue" >
<tr><td><b>Student id<b><td>:<td>${studentdetail.get(0).sid}</td></tr>
<tr><td><b>Name<b><td>:<td>${studentdetail.get(0).name}</td></tr>
<tr><td><b>Dept<b><td>:<td>${studentdetail.get(0).dept}</td></tr>
<tr><td><b>City<b><td>:<td>${studentdetail.get(0).city}</td></tr>
</table><br><br>
<input type="text" id="sid" value="${studentdetail.get(0).sid}" hidden>
<button id="showresult">Result</button>
<a href="logout"><button>Logout</button></a>
<br><br>
<table border="1px" id="resulttable">

</table>
</center>

</body>
</html>