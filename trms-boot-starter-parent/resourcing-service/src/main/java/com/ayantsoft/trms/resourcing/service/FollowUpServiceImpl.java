package com.ayantsoft.trms.resourcing.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayantsoft.trms.resourcing.dao.FollowUpDao;
import com.ayantsoft.trms.resourcing.model.FollowUp;

@Service
public class FollowUpServiceImpl implements Serializable,FollowUpService {

	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = 8737586512013419160L;
	
	@Autowired
	private FollowUpDao followUpDao;
	
	@Override
	public void addFollowup(FollowUp followUp) {
		
		System.out.println("FOLLOW UP SERVICE CALL");
		followUpDao.addFollowup(followUp);
	}

	@Override
	public List<FollowUp> listByCandidateId(String candidateId) {
		return followUpDao.listByCandidateId(candidateId);
	}
}
