package com.ayantsoft.trms.resourcing.service;

import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ayantsoft.trms.resourcing.dao.PhoneLogsDao;
import com.ayantsoft.trms.resourcing.lazy.model.LazyLoadEvent;
import com.ayantsoft.trms.resourcing.lazy.model.LazyPhoneLogDto;
import com.ayantsoft.trms.resourcing.model.PhoneLogs;

@Service
public class PhoneLogsServiceImpl implements Serializable,PhoneLogsService {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5482870051806872216L;
	
	
	@Autowired
	private PhoneLogsDao phoneLogsDao;

	@Override
	public LazyPhoneLogDto listByEmployeeId(LazyLoadEvent lazyLoadEvent,String employeeId){
		return phoneLogsDao.listByEmployeeId(lazyLoadEvent, employeeId);
	}

	@Override
	public List<PhoneLogs> listByCandidateId(String candidateId) {
		return phoneLogsDao.listByCandidateId(candidateId);
	}
}
