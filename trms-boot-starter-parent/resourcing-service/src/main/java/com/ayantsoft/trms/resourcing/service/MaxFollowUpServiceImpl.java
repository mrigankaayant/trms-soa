package com.ayantsoft.trms.resourcing.service;

import java.io.Serializable;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ayantsoft.trms.resourcing.dao.MaxFollowUpDao;
import com.ayantsoft.trms.resourcing.lazy.model.LazyFreepoolCandidateDto;
import com.ayantsoft.trms.resourcing.lazy.model.LazyLoadEvent;
import com.ayantsoft.trms.resourcing.model.MaxFollowUp;

@Service
public class MaxFollowUpServiceImpl implements Serializable,MaxFollowUpService {

	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = 6563632397035742532L;

	@Autowired
	private MaxFollowUpDao maxFollowUpDao;

	@Override
	public void addMaxFollowup(MaxFollowUp maxFollowUp) {
		maxFollowUpDao.addMaxFollowUp(maxFollowUp);	
	}

	@Override
	public MaxFollowUp findByCandidateId(String candidateId) {
		return maxFollowUpDao.findByCandidateId(candidateId);
	}

	@Override
	public void updateMaxFollowUp(MaxFollowUp maxFollowUp) {
		maxFollowUpDao.updateMaxFollowUp(maxFollowUp);
	}

	@Override
	public LazyFreepoolCandidateDto list(LazyLoadEvent lazyLoadEvent, Date dateBefore30Days) {
		return maxFollowUpDao.list(lazyLoadEvent, dateBefore30Days); 
	}
}
