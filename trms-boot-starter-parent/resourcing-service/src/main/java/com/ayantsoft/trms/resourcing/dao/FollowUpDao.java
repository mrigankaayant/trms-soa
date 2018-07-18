package com.ayantsoft.trms.resourcing.dao;

import java.util.List;

import com.ayantsoft.trms.resourcing.model.FollowUp;

public interface FollowUpDao {
	
	void addFollowup(FollowUp followup);
	List<FollowUp> listByCandidateId(String candidateId);

}
