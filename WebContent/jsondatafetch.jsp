<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js" ></script>
<meta charset="UTF-8">
<title>JSON Demo</title>
<style>
.json{
display:flex;
margin:20px;
}

</style>
</head>
<body>
<h2>JSON Array</h2>
<div class="json">
<p id="jsontext"></p>
<div>
<p>Problem fix</p>
<button id="btn">Click Here</button><br><br>
<table id="name" border="1"></table>
</div>
<div>
<p>Problem 1</p>
<button id="btn2">Click Here</button><br><br>
<table id="name2" border="1"></table>
</div>
<div>
<p>problem 2<p>
<button id="btn3">Click Here</button>
<table id="name3" border="1"></table>
</div>
</div>
<script type="text/javascript">
$(document).ready(function(){
	$("#btn").click(function(){
		$.ajax({
			url: "jsondemo",
			success: function(result){
				var jsonobj = JSON.parse(result);
				var result='';
				for(var i=0;i<jsonobj.length;i++){
					result = result+"<tr><td>"+jsonobj[i].name+"<td>"+jsonobj[i].age+"</td></tr>"
					$("#name").html(result);
					
				}
			}
		})
	});
	$("#btn2").click(function(){
		$.ajax({
			url: "jsondemo",
			success: function(result){
				var jsonobj = JSON.parse(result);
				
				for(var i=0;i<jsonobj.length;i++){
					$("#name2").html("<tr><td>"+jsonobj[i].name+"<td>"+jsonobj[i].age+"</td></tr>");
					
				}
			}
		})
	});
	$("#btn3").click(function(){
		$.ajax({
			url: "jsondemo",
			success: function(result){
				var jsonobj = JSON.parse(result);
				for(var i=0;i<jsonobj.length;i++){
					$("#name3").append("<tr><td>"+jsonobj[i].name+"<td>"+jsonobj[i].age+"</td></tr>");
					
				}
			}
		})
	});
});

</script>
</body>
</html>