$(function(){
	
	//1. 解析url, 获取cid
	//1. 截取？后面的内容
	var index = location.href.lastIndexOf("?");
	var params = location.href.substr(index+1); //aid=1&cid=2
	
	//2. 按照&进行分割
	var arr = params.split("&");
	for(var i=0; i<arr.length;i++)
	{
		if(arr[i].startsWith("aid"))
		{
			var index = arr[i].lastIndexOf("=");
			var aid = arr[i].substr(index+1);
		}
		if(arr[i].startsWith("cid"))
		{
			var index = arr[i].lastIndexOf("=");
			var cid = arr[i].substr(index+1);
		}		
	}

	//2. 发送ajax请求
	$.ajax({
		
		url:"candidate/"+aid+"/"+cid,
		type:"get",
		dataType:"json",
		success:function(data)
		{
			console.log(data);
			//imgurl & cname
			$("#imgurl").attr("src","img/"+data.imgurl);
			$("#cname").html(data.cname);
			$("#cid").html(data.cid);
			$("#tickets").html(data.tickets);
			$("#hots").html(data.hots);
			$("#gifts").html(data.gifts);
			$("#cdeclaration").html(data.cdeclaration);
			//更新图片
			for(var i=0;i<data.images.length;i++)
			{
				$("#images").append('<img src="img/'+data.images[i].imgurl+'" />')
			}
			
			//把data放在本地存储里
		    //在js中，对象-》json字符串互转 JSON 
			//JSON.parse() 字符串-》对象
			//JSON.stringify() 对象-》字符串
			sessionStorage.c = JSON.stringify(data);
			
			
		}
		
	});
	
	//设置投票的点击事件
	$("#btn_vote").click(function(){
		
		
		$.ajax({
			url:"candidate/"+aid+"/"+cid,
			type:"put",
			dataType:"json",
			success:function(data)
			{
				alert(data.result);
				if(data.result == "投票成功")
				{
					$("#tickets").html(parseInt($("#tickets").html())+1);
				    //更新sessionStorage的信息
					//1. 字符串-》对象
					var c = JSON.parse(sessionStorage.c);
					//2. 修改对象属性
					c.tickets = $("#tickets").html();
					//3. 对象-》 字符串
					var str = JSON.stringify(c);
					//4. 把字符串放在sessionStorage
					sessionStorage.c = str;
				}
			}
			
		});
	
	});
	
	//定义回首页
	$("#gohome").click(function(){
		
		location.href="index.html?aid="+aid;
		
	});
	
	//定义送礼物事件
	$("#go_lw").click(function(){
		
		location.href="lw.html?aid="+aid+"&cid="+cid;
		
	});
	
	wx.onMenuShareAppMessage({
		title: '投票了投票了投票了', // 分享标题
		desc: '请为您心仪的选手投票', // 分享描述
		link: '', // 分享链接，该链接域名或路径必须与当前页面对应的公众号JS安全域名一致
		imgUrl: 'img/a.jpg', // 分享图标
		type: '', // 分享类型,music、video或link，不填默认为link
		dataUrl: '', // 如果type是music或video，则要提供数据链接，默认为空
		success: function () {
		// 用户确认分享后执行的回调函数
		},
		cancel: function () {
		// 用户取消分享后执行的回调函数
		}
		});
	
})
