package com.neuedu.model.mapper;

import java.util.List;

import com.neuedu.model.po.Candidate;
/**
 * 
 * @author feiyy
 *
 */
public interface CandidateMapper {
	
	/**
	 * 
	 * @param aid
	 * @param start �ӵڼ�����ʼ
	 * @param pageSize ȡ����
	 * @return
	 */
	public List<Candidate> getCandidates(int aid, int start, int pageSize);

    public List<Candidate> getCandiateByName(String name);
    
    public void addCandidate(Candidate c);
    
    public Candidate getCandidateById(int cid);
    
    public void updateCandidateHots(int cid);
    
    public void updateCandidateTickets(int cid);
    
    public List<Candidate> topTen(int aid);
    
    public void updateCandidateGifts(int cid, int dianshu);
    
     
}
