package com.ayantsoft.trms.resourcing.dao;

import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import com.ayantsoft.trms.resourcing.info.DatabaseInfo;
import com.ayantsoft.trms.resourcing.model.PayType;

@Repository
public class PayTypeDaoImpl implements PayTypeDao,Serializable {

	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = -4370321867598809315L;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public List<PayType> list() {
		List<PayType> list = null;
		try{
			list = mongoTemplate.findAll(PayType.class,DatabaseInfo.PAYTYPE_COLLECTION);
		}catch(Exception e){
			e.printStackTrace();
			try{
				throw new Exception("PAYTYPE LIST EXCEPTION");
			}catch(Exception e1){
				e1.printStackTrace();
			}
		}
		return list;
	}
}
