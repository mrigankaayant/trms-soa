package com.ayantsoft.trms.resourcing.service;

import java.util.List;
import com.ayantsoft.trms.resourcing.model.PhoneLogs;

public interface PhoneLogsService {
	
	List<PhoneLogs> listByEmployeeId(String employeeId);
	List<PhoneLogs> listByCandidateId(String candidateId);

}
