package com.neuedu.model.mapper;

import java.util.List;

import com.neuedu.model.po.Prize;

public interface PrizeMapper {
	
	public List<Prize> getPrizes(int aid);

}
