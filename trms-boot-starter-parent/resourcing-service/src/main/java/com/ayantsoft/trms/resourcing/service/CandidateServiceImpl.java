package com.ayantsoft.trms.resourcing.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ayantsoft.trms.resourcing.dao.CandidateDao;
import com.ayantsoft.trms.resourcing.model.Candidate;

@Service
public class CandidateServiceImpl implements CandidateService,Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -8847046858890478366L;
	
	
	@Autowired
	private CandidateDao candidateDao;

	@Override
	public void addCandidate(Candidate candidate) {
		candidateDao.addCandidate(candidate);
	}

	@Override
	public Candidate checkEmail(String email, String id) {
		return candidateDao.checkEmail(email, id);
	}

	@Override
	public Candidate checkMobile(String phone, String id) {
		return candidateDao.checkEmail(phone, id);
	}
}
