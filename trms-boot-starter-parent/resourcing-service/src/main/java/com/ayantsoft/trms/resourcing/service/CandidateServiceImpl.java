package com.ayantsoft.trms.resourcing.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ayantsoft.trms.resourcing.dao.CandidateDao;
import com.ayantsoft.trms.resourcing.dto.SearchDto;
import com.ayantsoft.trms.resourcing.lazy.model.LazyCandidateDto;
import com.ayantsoft.trms.resourcing.lazy.model.LazyLoadEvent;
import com.ayantsoft.trms.resourcing.model.Candidate;

@Service
public class CandidateServiceImpl implements CandidateService,Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -8847046858890478366L;


	@Autowired
	private CandidateDao candidateDao;

	@Override
	public void addCandidate(Candidate candidate) {
		candidateDao.addCandidate(candidate);
	}

	@Override
	public Candidate checkEmail(String email, String id) {
		return candidateDao.checkEmail(email, id);
	}

	@Override
	public Candidate checkMobile(String phone, String id) {
		return candidateDao.checkMobile(phone, id);
	}

	@Override
	public Candidate findCandidateById(String candidateId) {
		return candidateDao.findById(candidateId);
	}

	@Override
	public void updateCandidate(Candidate candidate) {
		candidateDao.updateCandidate(candidate);

	}

	@Override
	public LazyCandidateDto list(LazyLoadEvent lazyLoadEvent,String employeeId) {
		return candidateDao.list(lazyLoadEvent,employeeId);
	}

	@Override
	public Candidate searchCandidate(SearchDto searchDto) {
		return candidateDao.searchCandidate(searchDto);
	}

	@Override
	public LazyCandidateDto list(LazyLoadEvent lazyLoadEvent) {
		return candidateDao.list(lazyLoadEvent);
	}

	@Override
	public List<Candidate> findCandidateByProperty(String propertyName,String propertyValue) {
		return candidateDao.findCandidateByProperty(propertyName,propertyValue); 
	}
}
