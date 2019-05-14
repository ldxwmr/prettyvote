$(function(){

	$.ajax({
		url:"prizes/"+aid,
		type:"get",
		dataType:"json",
		success:function(data)
		{
			for(var i=0; i<data.length;i++)
			{
				var str = '<div class="prize">';
				str += '<img src="img/'+data[i].pimg+'" />';
				str += '<p>'+data[i].level+'</p>';
				str += '<p>'+data[i].pname+'</p>';
				str += '<p>'+data[i].pcount+'个</p>';
				str += '</div>';
				
				$("#div1").append(str);
			}			
		}
		
		
	});
	
})
