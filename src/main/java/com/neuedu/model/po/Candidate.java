package com.neuedu.model.po;

import java.util.List;

public class Candidate {
	
	Integer cid;
	Integer aid;
	String cname;
	String cdeclaration;
	String mobile;
	String sex;
	String address;
	Integer hots;
	Integer gifts;
	Integer tickets;
	String imgurl;
	List<Images> images;
	
	public List<Images> getImages() {
		return images;
	}
	public void setImages(List<Images> images) {
		this.images = images;
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
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCdeclaration() {
		return cdeclaration;
	}
	public void setCdeclaration(String cdeclaration) {
		this.cdeclaration = cdeclaration;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getHots() {
		return hots;
	}
	public void setHots(Integer hots) {
		this.hots = hots;
	}
	public Integer getGifts() {
		return gifts;
	}
	public void setGifts(Integer gifts) {
		this.gifts = gifts;
	}
	public Integer getTickets() {
		return tickets;
	}
	public void setTickets(Integer tickets) {
		this.tickets = tickets;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	
}
