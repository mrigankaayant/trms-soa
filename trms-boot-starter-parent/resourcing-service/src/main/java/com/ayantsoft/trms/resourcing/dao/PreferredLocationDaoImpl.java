package com.ayantsoft.trms.resourcing.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import com.ayantsoft.trms.resourcing.info.DatabaseInfo;
import com.ayantsoft.trms.resourcing.model.Location;

@Repository
public class PreferredLocationDaoImpl implements PreferredLocationDao,Serializable{

	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = 366074020638141125L;
	
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public List<Location> list() {
		List<Location> list = null;
		try{
			list = mongoTemplate.findAll(Location.class,DatabaseInfo.PREF_LOCATION_COLLECTION);
		}catch(Exception e){
			e.printStackTrace();
			try{
				throw new Exception("PREFERRED LOCATION LIST EXCEPTION");
			}catch(Exception e1){
				e1.printStackTrace();
			}
		}
		return list;
	}

}
