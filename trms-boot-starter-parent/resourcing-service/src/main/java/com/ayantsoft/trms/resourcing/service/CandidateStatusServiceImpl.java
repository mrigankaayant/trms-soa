package com.ayantsoft.trms.resourcing.service;

import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ayantsoft.trms.resourcing.dao.CandidateStatusDao;
import com.ayantsoft.trms.resourcing.model.CandidateStatus;

@Service
public class CandidateStatusServiceImpl implements Serializable,CandidateStatusService{

	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = 601104939441941141L;
	
	@Autowired
	private CandidateStatusDao candidateStatusDao;

	@Override
	public List<CandidateStatus> list() {
		return candidateStatusDao.list();
	}

}
