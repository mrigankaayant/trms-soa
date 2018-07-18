package com.ayantsoft.trms.resourcing.service;

import java.util.List;

import com.ayantsoft.trms.resourcing.model.FollowUp;

public interface FollowUpService {
	
	void addFollowup(FollowUp followUp);
	List<FollowUp> listByCandidateId(String candidateId);
}
