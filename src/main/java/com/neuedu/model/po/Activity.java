package com.neuedu.model.po;

import java.util.Date;
import java.util.List;

public class Activity {	
	
	private Integer aid;
	private String title;
	private String desc;
	private String imgurl;
	private Date starttime;
	private Date endtime;
	private Integer totalpeople;
	private Integer totaltickets;
	private Integer totalaccess;
	private Integer votelimit;
	private List<Candidate> cs;
	
	public List<Candidate> getCs() {
		return cs;
	}
	public void setCs(List<Candidate> cs) {
		this.cs = cs;
	}
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public Date getStarttime() {
		return starttime;
	}
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	public Date getEndtime() {
		return endtime;
	}
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	public Integer getTotalpeople() {
		return totalpeople;
	}
	public void setTotalpeople(Integer totalpeople) {
		this.totalpeople = totalpeople;
	}
	public Integer getTotaltickets() {
		return totaltickets;
	}
	public void setTotaltickets(Integer totaltickets) {
		this.totaltickets = totaltickets;
	}
	public Integer getTotalaccess() {
		return totalaccess;
	}
	public void setTotalaccess(Integer totalaccess) {
		this.totalaccess = totalaccess;
	}
	public Integer getVotelimit() {
		return votelimit;
	}
	public void setVotelimit(Integer votelimit) {
		this.votelimit = votelimit;
	}
}
