package com.ayantsoft.trms.resourcing.dao;

import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import com.ayantsoft.trms.resourcing.info.DatabaseInfo;
import com.ayantsoft.trms.resourcing.model.FollowUp;

@Repository
public class FollowUpDaoImpl implements FollowUpDao,Serializable {

	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = -3833970167125013114L;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private CommonDao commonDao;
	
	@Override
	public void addFollowup(FollowUp followup) {
		try{
			followup.setFollowupId(commonDao.getNextSequenceId("followup"));
			mongoTemplate.save(followup,DatabaseInfo.FOLLOWUP_COLLECTION); 
		}catch(Exception e){
			e.printStackTrace();
			try {
				throw new Exception("FOLLOWUP SAVE EXCEPTION");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	@Override
	public List<FollowUp> listByCandidateId(String candidateId) {
		List<FollowUp> list = null;
		try{	
			Query query = new Query();
			query.addCriteria(Criteria.where("candidateInfo.candidateId").is(candidateId));
			list = mongoTemplate.find(query,FollowUp.class,DatabaseInfo.FOLLOWUP_COLLECTION);
		}catch(Exception e){
			e.printStackTrace();
			try {
				throw new Exception("FOLLOWUP LIST EXCEPTION");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return list;
	}
}
