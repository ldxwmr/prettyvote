package com.neuedu.model.mapper;

import java.util.List;

import com.neuedu.model.po.LW;

public interface LWMapper {
	
	public List<LW> getAllLW();
	
	public LW getLWById(int lwid);
	
}
