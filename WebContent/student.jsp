<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js" ></script>
<!-- <script type="text/javascript" src="index.js"></script> -->
<link rel="stylesheet" href="style.css">
<title>Insert title here</title>
</head>
<body>
	<!-- Nav Bar -->
<ul>
  <li><a  href="home.jsp">Home</a></li>
  <li><a class="active" href="">Students</a></li>
  <li><a href="staff.jsp">Staffs</a></li>
  <li><a href="management.jsp">Management</a></li>
</ul>
<div id="studentLogin">
<form action="fetchdata" method="post">
	<center><label id="loginerror"></label></center><br>
    <label for="fname">Student Id</label>
    <input type="text" id="sid" name="sid" placeholder="Enter Student Id">

    <label for="lname">Password</label>
    <input type="password" id="password" name="password" placeholder="Enter Password..">
  	
  	<button id="studentLoginSubmit" type="submit">Submit</button>
  	</form>
 </div>
 <table id="studentdetail"></table>
 <div id="logincontent">
 <button id="showresult">Result</button>
 </div>
</body>
</html>