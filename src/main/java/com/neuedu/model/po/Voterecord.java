package com.neuedu.model.po;

import java.util.Date;

public class Voterecord {	
	Integer id;
	String openid;
	Integer cid;
	Integer aid;
	Date votetime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public Date getVotetime() {
		return votetime;
	}
	public void setVotetime(Date votetime) {
		this.votetime = votetime;
	}
}
