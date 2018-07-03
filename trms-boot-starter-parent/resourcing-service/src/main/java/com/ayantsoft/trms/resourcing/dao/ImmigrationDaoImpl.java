package com.ayantsoft.trms.resourcing.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.ayantsoft.trms.resourcing.info.DatabaseInfo;
import com.ayantsoft.trms.resourcing.model.Immigration;

@Repository
public class ImmigrationDaoImpl implements ImmigrationDao,Serializable {
	
	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = -5565334090251474567L;
	
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<Immigration> list() {
		List<Immigration> list = null;
		try{
			list = mongoTemplate.findAll(Immigration.class,DatabaseInfo.IMMIGRATION_COLLECTION);
		}catch(Exception e){
			e.printStackTrace();
			try{
				throw new Exception("IMMIGRATION LIST EXCEPTION");
			}catch(Exception e1){
				e1.printStackTrace();
			}
		}
		return list;
	}

}
