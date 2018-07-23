package com.ayantsoft.trms.resourcing.dao;

import java.util.List;
import com.ayantsoft.trms.resourcing.lazy.model.LazyLoadEvent;
import com.ayantsoft.trms.resourcing.lazy.model.LazyPhoneLogDto;
import com.ayantsoft.trms.resourcing.model.PhoneLogs;

public interface PhoneLogsDao {
	
	LazyPhoneLogDto listByEmployeeId(LazyLoadEvent lazyLoadEvent,String employeeId);
	List<PhoneLogs> listByCandidateId(String candidateId);

}
