package com.neuedu.model.service;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.neuedu.model.mapper.ActivityMapper;
import com.neuedu.model.mapper.CandidateMapper;
import com.neuedu.model.mapper.ImagesMapper;
import com.neuedu.model.mapper.LWMapper;
import com.neuedu.model.mapper.LWRecordMapper;
import com.neuedu.model.mapper.PrizeMapper;
import com.neuedu.model.mapper.VoterecordMapper;
import com.neuedu.model.po.Activity;
import com.neuedu.model.po.Candidate;
import com.neuedu.model.po.Images;
import com.neuedu.model.po.LW;
import com.neuedu.model.po.LWRecord;
import com.neuedu.model.po.Prize;
import com.neuedu.model.po.Voterecord;

@Service
public class VoteService {
	
	@Autowired
	private ActivityMapper activityMapper;
	
	@Autowired
	private CandidateMapper candidateMapper;
	
	@Autowired
	private VoterecordMapper voterecordMapper;
	
	@Autowired
	private PrizeMapper prizeMapper;
	
	@Autowired
	private ImagesMapper imagesMapper;
	
	@Autowired
	private LWMapper lwMapper;
	
	@Autowired
	private LWRecordMapper lwrecordMapper;
	
	public Activity selectActivityById(int aid)
	{
		//���»�ķ�����
		activityMapper.updateActivityAccess(aid);
		return activityMapper.getActivityById(aid);
	}
	
	public List<Candidate> selectCandiates(int aid, int pageNum, int pageSize)
	{
		return candidateMapper.getCandidates(aid, (pageNum-1)*pageSize, pageSize);
	}
	
	public List<Candidate> selectCandiateByName(String name)
	{
		return candidateMapper.getCandiateByName(name);
	}
	
	public void saveCandidate(Candidate c, MultipartFile[] upload,String uploadpath)
	{			
		//1. �ļ��ϴ�
		//��ȡimg·��
		for(int i=0; i<upload.length;i++)
		{
			String filename = System.currentTimeMillis()+upload[i].getOriginalFilename();
		    //�ļ���Ŀ����λ��
			File f = new File(uploadpath,filename);
			//���� ����ʱ�ļ���-��Ŀ���ַ
			try {
				upload[i].transferTo(f);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(i==0)
			{
				//��һ��ͼƬ
				c.setImgurl(filename);
				//2. addcandidate
				candidateMapper.addCandidate(c);
			}
			
			//3. addimage
			Images image = new Images();
			image.setCid(c.getCid());
			image.setImgurl(filename);
			imagesMapper.addImage(image);
		}
		//4. ���±�������
		activityMapper.updateActivityPeople(c.getAid());		
	}
	
	public Candidate getCandidateById(int cid)
	{
		return candidateMapper.getCandidateById(cid);
	}
	
	public void updateCandidate(int aid, int cid)
	{
		//1.����ѡ�ֵ��ȶ�
		candidateMapper.updateCandidateHots(cid);
		//2.���»�ķ�����
		activityMapper.updateActivityAccess(aid);
	}
	
	public boolean canVote(int aid)
	{
		Activity activity = activityMapper.getActivityById(aid);
		Date now = new Date();
		if(now.getTime()<activity.getEndtime().getTime() && now.getTime()>activity.getStarttime().getTime())
		{
			return true;
		}
		return false;
	}
	
	public void updateVoteInfos(int aid, int cid, String openid)
	{
		//1.����activity totaltickets
		activityMapper.updateActivityTickets(aid);
		//2.����candidate tickets
		candidateMapper.updateCandidateTickets(cid);
		//3.��voterecord������һ����¼
		Voterecord v = new Voterecord();
		v.setAid(aid);
		v.setCid(cid);
		v.setOpenid(openid);
		v.setVotetime(new Date());
		voterecordMapper.addVoterecord(v);
	}
	
	public List<Candidate> getTopTen(int aid)
	{
		return candidateMapper.topTen(aid);
	}
	
	public List<Prize> getPrizes(int aid)
	{
		return prizeMapper.getPrizes(aid);
	}
	
	public List<LW> getAllLW()
	{
		return lwMapper.getAllLW();
	}
	
	public void updateCandidateGifts(int aid, int cid, int lwid, int lwcount, String openid)
	{
		//0. ����lwid�õ��������ϸ��Ϣ
		LW lw = lwMapper.getLWById(lwid);
		//1. ����candidate gifts
		candidateMapper.updateCandidateGifts(cid, lw.getDianshu()*lwcount);
		//2. ��lwrecord�м�һ����¼
		LWRecord lwrecord = new LWRecord();
		lwrecord.setAid(aid);
		lwrecord.setCid(cid);
		lwrecord.setLwid(lwid);
		lwrecord.setLwcount(lwcount);
		lwrecord.setStime(new Date());
		lwrecord.setPrice(lw.getPrice());
		lwrecord.setOpenid(openid);
		
		lwrecordMapper.addLWRecord(lwrecord);
	}
}
