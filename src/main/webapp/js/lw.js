$(function(){
	
	//显示当前选手的信息
	//从sessionStorage里把c得到,转成对象
	var c = JSON.parse(sessionStorage.c);
	
	$("#cimg").attr("src","img/"+c.imgurl);
	$("#cname").html(c.cname);
	$("#cid").html(c.cid);
	$("#tickets").html(c.tickets);
	$("#hots").html(c.hots);
	$("#gifts").html(c.gifts);
	
	//定义+的事件
	$("#plus").click(function(){
		
		var newcount = parseInt($("#count_text").val())+1;
		
		$("#count_text").val(newcount);
		
	});
	
	//定义-的事件
	$("#minus").click(function(){
		
		var oldcount = parseInt($("#count_text").val());
		if(oldcount>1)
		{
			$("#count_text").val(oldcount-1);
		}

	});
	
	//发送ajax请求，获得所有的礼物
	$.ajax({
		url:"lws",
		type:"get",
		dataType:"json",
		success:function(data)
		 {
			console.log(data);	
			for(var i=0; i<data.length;i++)
			{
			   var str = '<div class="lw" data-id="'+data[i].lwid+'">';
			   str+='<img src="img/'+data[i].lwimg+'" />';
			   str+='<p>'+data[i].lwname+'</p>';
			   str+='<p>点数:'+data[i].dianshu+'点</p>';
			   str+='<p>价钱:'+data[i].price+'</p>';
			   str+='<div class="mask">';
			   str+='<i class="fa fa-check-circle" aria-hidden="true"></i>';
			   str+='</div>';
			   str+='</div>';
			   
			   $("#div2_1").append(str);
			  
			}
		 }
		
	});
	
	//设置礼物的选中事件
	$(document).on("click",".lw",function(){
		
		//1. 删除所有.lw上的.show class
		$(".lw").removeClass("show");
		//2. 在当前选中的元素上加上.show class
		$(this).addClass("show");
		
	})
	
	//设置btn_pay的事件
	$("#btn_pay").click(function(){
		
		//1. aid直接用
		//2. cid c.cid
		//3. 得到lwid
		var lwid = $(".show").attr("data-id");
		//4. 得到lwcount
		var lwcount = $("#count_text").val();
		//5. 发送ajax
		$.ajax({
			url:"candidate/lw/"+aid+"/"+c.cid+"/"+lwid+"/"+lwcount,
			type:"put",
			dataType:"json",
			success:function(data)
			{
				alert("购买礼物成功");
				//把页面上的礼物数更新一下
				$("#gifts").html(data.gifts);
				
			}			
		})
		
	});
	
	
})
