package com.neuedu.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.model.po.Prize;
import com.neuedu.model.service.VoteService;

@Controller
public class PrizeController {
	
	@Autowired
	private VoteService voteService;
	
	@RequestMapping(value="/prizes/{aid}", method=RequestMethod.GET)
	@ResponseBody
	public List<Prize> getPrizes(@PathVariable int aid)
	{
		return voteService.getPrizes(aid);
	}

}
