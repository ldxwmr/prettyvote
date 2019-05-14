package com.neuedu.controllers;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.neuedu.model.po.Candidate;
import com.neuedu.model.service.VoteService;

@Controller
public class BaomingController {
	
	@Autowired
	private VoteService myService;
	
	@RequestMapping(value="/candidates",method=RequestMethod.POST)
	@ResponseBody
	public String baoming(Candidate c, @RequestParam MultipartFile[] upload, HttpServletRequest request)
	{
		//获得当前工程img路径E:\apache-tomcat-8.0.29\webapps\WeiXinVote\img
		String uploadpath = request.getServletContext().getRealPath("/img");
		//调用service
		myService.saveCandidate(c, upload,uploadpath);
		
		return "{\"result\":true}";
	}

}
