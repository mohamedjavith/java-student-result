<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js" ></script>
<script type="text/javascript" src="index.js"></script> 

<title>Staff Home</title>
<style>
#liststudenttable {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 50%;
}

#liststudenttable td, #liststudenttable th, #studentresultviewtable td, #studentresultviewtable th {
  border: 1px solid #ddd;
  padding: 8px;
}

#liststudenttable tr:nth-child(even), #studentresultviewtable tr:nth-child(even){background-color: #f2f2f2;}

#liststudenttable tr:hover, #studentresultviewtable tr:hover {background-color: #ddd;}

#liststudenttable th, #studentresultviewtable th {
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
if(session.getAttribute("staffid")==null){
	response.sendRedirect("staff.jsp");
}

%>
<center>
<h1>Hello, <i>${name}</i></h1>
<table bgcolor="lightgreen">
<tr><td><b>Staff Id<b><td>:<td>${staffdetail.get(0).staffid}</td></tr>
<tr><td><b>Name<b><td>:<td>${staffdetail.get(0).name}</td></tr>
<tr><td><b>Dept<b><td>:<td>${staffdetail.get(0).dept}</td></tr>
</table><br><br>

<div id="buttons">
<button id="addstudent">Add Student</button>
<button id="addstudentresult">Add Student Result</button>
<button id="liststudent">List Students Details</button>
<button id="studentresultview">Student Result View</button>
<a href="logout"><button>Logout</button></a>
</div><br>
<div id="addstudentform">
<p id="msg"></p>
<input type="text" id="studentname" name="studentname" placeholder="Enter Student Name"><br>
<input type="text" id="studentdept" name="studentdept" placeholder="Enter Student Department"><br>
<input type="text" id="studentcity" name="studentcity" placeholder="Enter Student City"><br><br>
<button type="submit" id="addstudentsubmit">Add</button>

</div><br>
<div id="studentresultform">

<p id="msgres"></p>

<input type="text" id="studentidresult" name="studentidresult" placeholder="Enter Student Id"><br>
<input type="text" id="subjectcode" name="subjectcode" placeholder="Enter Subject Code"><br>
<input type="text" id="mark" name="mark" placeholder="Enter Mark"><br><br>
<button type="submit" id="studentresultsubmit">Add Mark</button>

</div><br>
<div id="studentresultviewdiv">  
<input type="text" id="sid" placeholder="Enter Student Id">
<button id="studentresultviewsubmit">View Result</button><br><br>
<table id="studentresultviewtable" ></table>
</div>


<div id="liststudentdiv"> 
<table id="liststudenttable" border="1"></table>
</div>

<div>
<table id="studentupdatetable">

<tr><td>Name <td><input type="text" id="sname" name="name"></td></tr>
<tr><td>City <td><input type="text" id="city" name="city"></td></tr>
<tr><td>Department <td><input type="text" id="dept" name="dept"><input type="text" id="sid" name="sid" hidden></td></tr>
<tr><td><button>Update</button></td></tr>
</table>
</div>
</center><br><br><br>

</body>
</html>