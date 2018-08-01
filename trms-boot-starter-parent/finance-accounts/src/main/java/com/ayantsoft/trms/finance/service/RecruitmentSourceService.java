package com.ayantsoft.trms.finance.service;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import com.ayantsoft.trms.finance.model.RecruitmentSource;

public interface RecruitmentSourceService {
	
	List<RecruitmentSource> list(HttpServletRequest request);
}
