package com.ayantsoft.trms.finance.service;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import com.ayantsoft.trms.finance.model.CandidateStatus;

public interface CandidateStatusService {
	
	List<CandidateStatus> list(HttpServletRequest request);

}
