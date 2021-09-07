<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js" ></script>
<link rel="stylesheet" href="style.css">
<title>Insert title here</title>
</head>
<body>
<%
if(session.getAttribute("staffid")!=null){
	response.sendRedirect("staffhomepage");
}else{
%>
	<!-- Nav Bar -->
<ul>
  <li><a  href="home.jsp">Home</a></li>
  <li><a href="student.jsp">Students</a></li>
  <li><a class="active" href="">Staffs</a></li>
  <li><a href="management.jsp">Management</a></li>
</ul>
<div id="studentLogin">
<form action="staffhomepage" method="post">
<h1>Staff Login</h1>
	<center><label id="loginerror"></label></center><br>
    <label for="fname">Staff Id</label>
    <input type="text" id="sid" name="staffid" placeholder="Enter Staff Id">

    <label for="lname">Password</label>
    <input type="password" id="password" name="password" placeholder="Enter Password..">
  	
  	<button id="studentLoginSubmit" type="submit">Submit</button>
  	</form>
  	<%
}
  	%>
 </div>
</body>
</html>