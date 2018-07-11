package com.ayantsoft.trms.resourcing.service;

import com.ayantsoft.trms.resourcing.lazy.model.LazyCandidateDto;
import com.ayantsoft.trms.resourcing.lazy.model.LazyLoadEvent;
import com.ayantsoft.trms.resourcing.model.Candidate;

public interface CandidateService {

	void addCandidate(Candidate candidate);
	Candidate findCandidateById(String candidateId);
	Candidate checkEmail(String email, String id);
	Candidate checkMobile(String phone,String id);
	void updateCandidate(Candidate candidate);
	//List<Candidate> list(boolean isAdmin,String employeeId);
	LazyCandidateDto list(LazyLoadEvent lazyLoadEvent,String employeeId);
}
