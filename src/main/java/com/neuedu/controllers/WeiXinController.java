package com.neuedu.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.utils.CommonUtil;

import net.sf.json.JSONObject;

@Controller
public class WeiXinController {
	
	@RequestMapping("/getcode")	
	public String getCode(HttpServletRequest request)
	{
		//1.得到微信返给的code
		String code = request.getParameter("code");
		
		//2.根据code得到access_token和openid
		String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
		url = url.replace("APPID", "wxbf9210646fd3bb89");
		url = url.replace("SECRET", "9c7874ad52b1f5ba54c5985e52ef1b82");
		url = url.replace("CODE", code);
		
		JSONObject obj = CommonUtil.httpsRequest(url, "GET");		
		//3.根据access_token和openid得到用户信息
		String url2 = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
		url2 = url2.replace("ACCESS_TOKEN", obj.getString("access_token"));
		url2 = url2.replace("OPENID", obj.getString("openid"));
		
		JSONObject obj2 = CommonUtil.httpsRequest(url2, "GET");
		//4.把当前用户信息放在session中
		request.getSession().setAttribute("userinfo", obj2);		
		//5. 页面跳转到index.html		
		return "redirect:index.html?aid=1";
	}

}
