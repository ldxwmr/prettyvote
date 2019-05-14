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
		    aid = arr[i].substr(index+1);
		}	
	}
	
	$("#menu_home").click(function(){
		
		location.href="index.html?aid="+aid;
		
	});
	
	
	$("#menu_baoming").click(function(){
		
		location.href="baoming.html?aid="+aid;
		
	});
	
    $("#menu_prize").click(function(){
		
		location.href="prize.html?aid="+aid;
		
	});
    
    $("#menu_rank").click(function(){
		
		location.href="rank.html?aid="+aid;
		
	});
	
	
})
