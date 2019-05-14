$(function(){
	
	$.ajax({
		url:"candidates/top10/"+aid,
		type:"get",
		dataType:"json",
		success:function(data)
		{
			for(var i=0; i<data.length;i++)
			{
				var str = '';
				if(i%2==0)
				{
					str+='<div class="c odd">';
				}
				else
				{
					str+='<div class="c">';
				}
				str+='<div class="c_1"><img src="img/'+data[i].imgurl+'"/></div>';
				str+='<div class="c_2">';
				str+='<p>'+data[i].cname+','+data[i].cid+'号</p>';
				str+='<p>票数'+data[i].tickets+'，礼物'+data[i].gifts+'</p>';
				str+='<p>'+data[i].cdeclaration+'</p>';
				str+='</div>';
				str+='<div class="c_3">'+(i+1)+'</div>';
				str+='</div>';
				
				$("#div1").append(str);
			}
		}
	});
	
	
})
