package com.ayantsoft.trms.resourcing.dao;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.ayantsoft.trms.resourcing.info.DatabaseInfo;
import com.ayantsoft.trms.resourcing.model.Candidate;

@Repository
public class CandidateDaoImpl implements CandidateDao,Serializable {
	
	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = -1177437504030163819L;

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private CommonDao commonDao;

	@Override
	public void addCandidate(Candidate candidate) {
		try{
			candidate.setCandidateId(commonDao.getNextSequenceId("candidate"));
			mongoTemplate.save(candidate,DatabaseInfo.CANDIDATECOLLECTION); 
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
