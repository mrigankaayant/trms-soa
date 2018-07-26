package com.ayantsoft.trms.resourcing.dao;

import com.ayantsoft.trms.resourcing.dto.SearchDto;
import com.ayantsoft.trms.resourcing.lazy.model.LazyCandidateDto;
import com.ayantsoft.trms.resourcing.lazy.model.LazyLoadEvent;
import com.ayantsoft.trms.resourcing.model.Candidate;

public interface CandidateDao {
	
	void addCandidate(Candidate candidate);
	Candidate findById(String candidateId);
	Candidate checkEmail(String email, String id);
	Candidate checkMobile(String phone,String id);
	void updateCandidate(Candidate candidate);
	LazyCandidateDto list(LazyLoadEvent lazyLoadEvent,String employeeId);
	Candidate searchCandidate(SearchDto searchDto);
	LazyCandidateDto list(LazyLoadEvent lazyLoadEvent);
}
