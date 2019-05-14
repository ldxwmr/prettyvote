package com.neuedu.model.po;

import java.util.Date;

public class LWRecord {
	
	Integer id;
	String openid;
	Integer cid;
	Integer lwid;
	Integer lwcount;
	Integer aid;
	Date stime;
	Double price;
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
	public Integer getLwid() {
		return lwid;
	}
	public void setLwid(Integer lwid) {
		this.lwid = lwid;
	}
	public Integer getLwcount() {
		return lwcount;
	}
	public void setLwcount(Integer lwcount) {
		this.lwcount = lwcount;
	}
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public Date getStime() {
		return stime;
	}
	public void setStime(Date stime) {
		this.stime = stime;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}

}
