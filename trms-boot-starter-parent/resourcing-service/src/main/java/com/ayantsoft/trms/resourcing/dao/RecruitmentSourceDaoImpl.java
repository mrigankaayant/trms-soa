package com.ayantsoft.trms.resourcing.dao;

import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import com.ayantsoft.trms.resourcing.info.DatabaseInfo;
import com.ayantsoft.trms.resourcing.model.RecruitmentSource;

@Repository
public class RecruitmentSourceDaoImpl implements RecruitmentSourceDao,Serializable {

	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = -2124210551287214005L;

	@Autowired
	private MongoTemplate mongoTemplate;
	

	@Override
	public List<RecruitmentSource> list() {
		List<RecruitmentSource> list = null;
		try{
			list = mongoTemplate.findAll(RecruitmentSource.class,DatabaseInfo.RECRUITMENTSOURCE);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
}
