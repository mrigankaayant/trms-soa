package com.ayantsoft.trms.finance.service;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import com.ayantsoft.trms.finance.model.Immigration;

public interface ImmigrationService {
	
	List<Immigration> list(HttpServletRequest request);

}
