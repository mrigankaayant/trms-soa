package com.ayantsoft.trms.resourcing.service;

import com.ayantsoft.trms.resourcing.model.Candidate;

public interface CandidateService {

	void addCandidate(Candidate candidate);
	Candidate checkEmail(String email, String id);
	Candidate checkMobile(String phone,String id);
}
