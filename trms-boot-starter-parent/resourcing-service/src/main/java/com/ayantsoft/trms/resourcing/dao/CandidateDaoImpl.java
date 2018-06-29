package com.ayantsoft.trms.resourcing.dao;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
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
			mongoTemplate.save(candidate,DatabaseInfo.CANDIDATE_COLLECTION); 
		}catch(Exception e){
			e.printStackTrace();
		}
	}


	@Override
	public Candidate checkEmail(String email, String id) {
		Candidate candidate = null;
		try{
			Criteria criteria = new Criteria();
			if("0".equals(id)){
				criteria.orOperator(Criteria.where("email").is(email.trim()),Criteria.where("altEmail").is(email.trim()));
				Query query = new Query(criteria);
				candidate = mongoTemplate.findOne(query,Candidate.class,DatabaseInfo.CANDIDATE_COLLECTION);
			}else{
				Criteria c1 = criteria.orOperator(Criteria.where("email").is(email.trim()),Criteria.where("altEmail").is(email.trim()));
				Criteria c2 = Criteria.where("candidateId").ne(id);
				Criteria criteria2 = new Criteria();
				criteria2.andOperator(c1,c2);
				Query query = new Query(criteria2);
				candidate = mongoTemplate.findOne(query,Candidate.class,DatabaseInfo.CANDIDATE_COLLECTION);
			}

		}catch(Exception e){
			e.printStackTrace();
		}
		return candidate;
	}



	@Override
	public Candidate checkMobile(String phone,String id) {
		Candidate candidate = null;
		try{
			Criteria criteria = new Criteria();
			if("0".equals(id)){
				criteria.orOperator(Criteria.where("workMobile").is(phone.trim()),Criteria.where("phone").is(phone.trim()));
				Query query = new Query(criteria);
				candidate = mongoTemplate.findOne(query,Candidate.class,DatabaseInfo.CANDIDATE_COLLECTION);
			}else{
				Criteria c1 = criteria.orOperator(Criteria.where("workMobile").is(phone.trim()),Criteria.where("phone").is(phone.trim()));
				Criteria c2 = Criteria.where("candidateId").ne(id);
				Criteria criteria2 = new Criteria();
				criteria2.andOperator(c1,c2);
				Query query = new Query(criteria2);
				candidate = mongoTemplate.findOne(query,Candidate.class,DatabaseInfo.CANDIDATE_COLLECTION);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return candidate;
	}
}
