package com.ayantsoft.trms.finance.service;

import javax.servlet.http.HttpServletRequest;
import com.ayantsoft.trms.finance.dto.LazyCandidateDto;
import com.ayantsoft.trms.finance.lazy.model.LazyLoadEvent;

public interface CandidateService {
	
	LazyCandidateDto list(HttpServletRequest request,LazyLoadEvent lazyLoadEvent);

}
