$(document).ready(function(){
	$('#studentupdatetable').hide();
	$('#addstudentform').hide();
	$('#resulttable').hide();
	$('#addstudent').click(function(){
		$('#studentresultform').hide();
		$('#studentresultviewdiv').hide();
		$('#liststudenttable').hide();
		$('#addstudentform').toggle();
	});
	$('#studentresultform').hide();
	$('#addstudentresult').click(function(){
		$('#studentresultviewdiv').hide();
		$('#addstudentform').hide();
		$('#liststudenttable').hide();
		$('#studentresultform').toggle();
	});
	$('#showresult').click(function(){
		$.post('examresult',
			{
				sid:$('#sid').val()
				
			},
			function(data,status){
						console.log(status);
				  		$('#resulttable').html(data);
							
			});
			$('#resulttable').toggle();
	});
	//Staff Home Page
	// Add Student Details
	$("#addstudentsubmit").click(function(){
		if($("#studentname").val()=="" && $("#studentdept").val()=="" && $("#studentcity").val()==""){
			$("#msg").html("ALL FIELDS ARE REQUIRED");
			$('#msg').css('color','red');
			
		}else{
		$.post('addstudent',
			{
				studentname:$("#studentname").val(),
				studentdept:$("#studentdept").val(),
				studentcity:$("#studentcity").val()
			},
			function(data,status){
				$('#msg').html(data);
				$('#msg').css('color','green');
				$("#studentname").val('');
				$("#studentdept").val('');
				$("#studentcity").val('');
			});
	}	
	});
	//Staff Home Page
	// Student Result Upload
	$("#studentresultsubmit").click(function(){
		if($("#studentidresult").val()=="" && $("#subjectcode").val()=="" && $("#mark").val()==""){
			$("#msgres").html("ALL FIELDS ARE REQUIRED");
			$('#msgres').css('color','red');
			
		}else{
		$.post('addresult',
			{
				studentidresult:$("#studentidresult").val(),
				subjectcode:$("#subjectcode").val(),
				mark:$("#mark").val()
			},
			function(data,status){
				$('#msgres').html(data);
				$('#msgres').css('color','green');
				$("#studentidresult").val('');
				$("#subjectcode").val('');
				$("#mark").val('');
			});
	}	
	});
	// List Student details
	$('#liststudenttable').hide();
	$("#liststudent").click(function(){
		$('#liststudenttable').toggle();
		$.post('liststudentdetails',
			{
			name:'dummy'
			},
			function(data,status){
				$('#addstudentform').hide();
				$('#studentresultform').hide();
				$('#studentresultviewdiv').hide();
				$('#liststudenttable').html(data);
				console.log(status);	
			});
	});
	//student result view 
	$('#studentresultviewdiv').hide();
	$('#studentresultview').click(function(){
		$('#addstudentform').hide();
		$('#studentresultform').hide();
		$('#liststudenttable').hide();
		$('#studentresultviewdiv').toggle();
	});
	$('#studentresultviewsubmit').click(function(){
		$.post('examresult',
			{
				sid:$('#sid').val()
				
			},
			function(data,status){
						console.log(status);
						$('#addstudentform').hide();
						$('#studentresultform').hide();
						$('#liststudenttable').hide();
				  		$('#studentresultviewtable').html(data);
						$('#studentresultviewtable').show();
							
			});
	});
	
	
	
});






