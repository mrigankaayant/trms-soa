package com.ayantsoft.trms.resourcing.dao;

import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import com.ayantsoft.trms.resourcing.info.DatabaseInfo;
import com.ayantsoft.trms.resourcing.model.IncentiveStructure;

@Repository
public class IncentiveStructureDaoImpl implements Serializable,IncentiveStructureDao {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 9200797736423587897L;
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<IncentiveStructure> findIncentiveList(String typeFor) {
		List<IncentiveStructure> incentiveList = null;
		try{
			Query query = new Query();
			query.addCriteria(Criteria.where("typeFor").is(typeFor));
			incentiveList = mongoTemplate.find(query,IncentiveStructure.class,DatabaseInfo.INCENTIVE_STRUCTURE_COLLECTION);	
		}catch(Exception e){
			e.printStackTrace();
		}
		return incentiveList;
	}

}
