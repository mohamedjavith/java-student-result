<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="fileupload" method="post" enctype="multipart/form-data">
	
	<input type="text" name="name" id="name" placeholder="Enter Name"><br><br>
	<label>Image</label><br><br>
	<input type="file" name="image" id="image" multiple><br><br>
	<button name="submit">Submit</button>
	
	</form>
</body>
</html>