package com.neuedu.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.model.po.Activity;
import com.neuedu.model.po.Candidate;
import com.neuedu.model.service.VoteService;

@Controller
public class HomeController {
	
	@Autowired
	private VoteService voteService;
	
	@RequestMapping(value="/activity/{aid}", method=RequestMethod.GET)
	@ResponseBody
	public Activity getActivityById(@PathVariable int aid)
	{
		return voteService.selectActivityById(aid);
	}
	
	@RequestMapping(value="/candidates/{aid}/{pagenum}", method=RequestMethod.GET)
	@ResponseBody
	public List<Candidate> getCandiates(@PathVariable int aid, @PathVariable int pagenum)
	{
		return voteService.selectCandiates(aid, pagenum, 10);
	}
	
	@RequestMapping(value="/candidates/{name}", method=RequestMethod.GET)
	@ResponseBody
	public List<Candidate> getCandiates(@PathVariable String name)
	{
		System.out.println(name);
		return voteService.selectCandiateByName(name);
	}

}
