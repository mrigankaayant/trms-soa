package com.ayantsoft.trms.resourcing.dao;

import java.util.Date;
import com.ayantsoft.trms.resourcing.lazy.model.LazyFreepoolCandidateDto;
import com.ayantsoft.trms.resourcing.lazy.model.LazyLoadEvent;
import com.ayantsoft.trms.resourcing.model.MaxFollowUp;

public interface MaxFollowUpDao {
	
	void addMaxFollowUp(MaxFollowUp maxFollowUp);
	MaxFollowUp findByCandidateId(String candidateId);
	void updateMaxFollowUp(MaxFollowUp maxFollowUp);
	LazyFreepoolCandidateDto list(LazyLoadEvent lazyLoadEvent,Date dateBefore30Days);
}
