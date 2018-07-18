package com.ayantsoft.trms.resourcing.dao;

import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import com.ayantsoft.trms.resourcing.info.DatabaseInfo;
import com.ayantsoft.trms.resourcing.model.CandidateStatus;

@Repository
public class CandidateStatusDaoImpl implements Serializable,CandidateStatusDao {

	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = 2040401420372459362L;
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<CandidateStatus> list() {
		List<CandidateStatus> list = null;
		try{
			list = mongoTemplate.findAll(CandidateStatus.class,DatabaseInfo.CANDIDATE_STATUS_COLLECTION);
		}catch(Exception e){
			e.printStackTrace();
			try{
				throw new Exception("CANDIDATE STATUS LIST EXCEPTION");
			}catch(Exception e1){
				e1.printStackTrace();
			}
		}
		return list;
	}

}
