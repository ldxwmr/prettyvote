package com.neuedu.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.model.po.Candidate;
import com.neuedu.model.service.VoteService;

@Controller
public class RankController {
	
	@Autowired
	private VoteService voteService;
	
	@RequestMapping(value="/candidates/top10/{aid}", method=RequestMethod.GET)
	@ResponseBody
	public List<Candidate> getTopTen(@PathVariable int aid)
	{
		return voteService.getTopTen(aid);
	}

}
