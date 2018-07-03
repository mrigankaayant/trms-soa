package com.ayantsoft.trms.resourcing.dao;

import java.util.List;

import com.ayantsoft.trms.resourcing.model.Candidate;

public interface CandidateDao {
	
	void addCandidate(Candidate candidate);
	Candidate find(String candidateId);
	Candidate checkEmail(String email, String id);
	Candidate checkMobile(String phone,String id);
	void updateCandidate(Candidate candidate);
	List<Candidate> list(boolean isAdmin,String employeeId);
}
