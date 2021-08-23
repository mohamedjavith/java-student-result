$(document).ready(function(){
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