package com.ayantsoft.trms.resourcing.dao;

import com.ayantsoft.trms.resourcing.model.Candidate;

public interface CandidateDao {
	
	void addCandidate(Candidate candidate);
	Candidate checkEmail(String email, String id);
	Candidate checkMobile(String phone,String id);
	
}
