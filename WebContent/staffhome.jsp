<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js" ></script>
<script type="text/javascript" src="index.js"></script> 

<title>Insert title here</title>
</head>
<body>
<%
if(request.getAttribute("id")==null){
	response.sendRedirect("staff.jsp");
}

%>
<center>
<h1>Welcome, <i>${name}</i></h1>
<table bgcolor="lightgreen">
<tr><td><b>Staff Id<b><td>:<td>${id}</td></tr>
<tr><td><b>Name<b><td>:<td>${name}</td></tr>
<tr><td><b>Dept<b><td>:<td>${dept}</td></tr>
</table><br><br>

<div id="buttons">
<button id="addstudent">Add Student</button>
<button id="addstudentresult">Add Student Result</button>
</div><br>
<div id="addstudentform">
<form action="" method="post">
<input type="text" id="studentname" name="studentname" placeholder="Enter Student Name"><br>
<input type="text" id="studentdept" name="studentdept" placeholder="Enter Student Department"><br>
<input type="text" id="studentcity" name="studentcity" placeholder="Enter Student City"><br><br>
<button type="submit" id="addstudentsubmit">Add</button>
</form>
</div><br><br>
<div id="studentresultform">
<form action="" method="post">
<input type="text" id="studentname" name="studentidresult" placeholder="Enter Student Id"><br>
<input type="text" id="studentdept" name="subjectcode" placeholder="Enter Subject Code"><br>
<input type="text" id="studentcity" name="mark" placeholder="Enter Mark"><br><br>
<button type="submit" id="studentresultsubmit">Add Mark</button>
</form>
</div>
</center>

</body>
</html>