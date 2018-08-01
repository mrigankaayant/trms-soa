package com.ayantsoft.trms.finance.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import com.ayantsoft.trms.finance.dto.LazyCandidateDto;
import com.ayantsoft.trms.finance.lazy.model.LazyLoadEvent;
import com.ayantsoft.trms.finance.model.Candidate;

public interface CandidateService {
	
	LazyCandidateDto list(HttpServletRequest request,LazyLoadEvent lazyLoadEvent);
	List<Candidate> findCandidateByProperty(HttpServletRequest request,String propertyName,String propertyValue);
	Candidate findCandidateById(HttpServletRequest request,String candidateId);

}
