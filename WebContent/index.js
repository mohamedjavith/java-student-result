$(document).ready(function(){
	$('#addstudentform').hide();
	$('#addstudent').click(function(){
		
		$('#addstudentform').toggle();
	});
	$('#studentresultform').hide();
	$('#addstudentresult').click(function(){
		
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
	});
});