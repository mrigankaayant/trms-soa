package com.ayantsoft.trms.resourcing.dao;

import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import com.ayantsoft.trms.resourcing.info.DatabaseInfo;
import com.ayantsoft.trms.resourcing.model.PhoneLogs;

@Repository
public class PhoneLogsDaoImpl implements Serializable,PhoneLogsDao {

	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = -2203588017024747185L;
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<PhoneLogs> listByEmployeeId(String employeeId) {
		List<PhoneLogs> list = null;
		try{	
			Query query = new Query();
			query.addCriteria(Criteria.where("employeeId").is(employeeId));
			list = mongoTemplate.find(query,PhoneLogs.class,DatabaseInfo.PHONE_LOGS_COLLECTION);
		}catch(Exception e){
			e.printStackTrace();
			try {
				throw new Exception("PHONE LOGS LIST EXCEPTION");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public List<PhoneLogs> listByCandidateId(String candidateId) {
		List<PhoneLogs> list = null;
		try{	
			Query query = new Query();
			query.addCriteria(Criteria.where("candidateId").is(candidateId));
			list = mongoTemplate.find(query,PhoneLogs.class,DatabaseInfo.PHONE_LOGS_COLLECTION);
		}catch(Exception e){
			e.printStackTrace();
			try {
				throw new Exception("PHONE LOGS LIST EXCEPTION");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return list;
	}

}
