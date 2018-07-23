package com.ayantsoft.trms.resourcing.service;

import java.util.List;
import com.ayantsoft.trms.resourcing.lazy.model.LazyLoadEvent;
import com.ayantsoft.trms.resourcing.lazy.model.LazyPhoneLogDto;
import com.ayantsoft.trms.resourcing.model.PhoneLogs;

public interface PhoneLogsService {
	
	LazyPhoneLogDto listByEmployeeId(LazyLoadEvent lazyLoadEvent,String employeeId);
	List<PhoneLogs> listByCandidateId(String candidateId);

}
