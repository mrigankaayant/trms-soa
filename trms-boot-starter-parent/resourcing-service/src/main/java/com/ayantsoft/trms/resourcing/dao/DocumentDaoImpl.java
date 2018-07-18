package com.ayantsoft.trms.resourcing.dao;

import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import com.ayantsoft.trms.resourcing.info.DatabaseInfo;
import com.ayantsoft.trms.resourcing.model.Documents;

@Repository
public class DocumentDaoImpl implements DocumentDao,Serializable {

	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = 4768558931193149075L;

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private CommonDao commonDao;

	@Override
	public void save(Documents documents) {
		try{
			documents.setDocumentId(commonDao.getNextSequenceId("document"));
			mongoTemplate.save(documents,DatabaseInfo.DOUMENTS_COLLECTION); 
		}catch(Exception e){
			e.printStackTrace();
			try{
				throw new Exception("DOCUMENT SAVE EXCEPTION");
			}catch(Exception e1){
				e1.printStackTrace();
			}
		}
	}

	@Override
	public Documents find(String fileName) {
		Documents documents = null;
		try{	
			Query query = new Query();
			query.addCriteria(Criteria.where("fileName").is(fileName));
			documents = mongoTemplate.findOne(query,Documents.class,DatabaseInfo.DOUMENTS_COLLECTION);
		}catch(Exception e){
			e.printStackTrace();
			try {
				throw new Exception("DOCUMENTS FIND EXCEPTION");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return documents;
	}


	@Override
	public void delete(Documents documents) {
		try{	
			mongoTemplate.remove(documents,DatabaseInfo.DOUMENTS_COLLECTION);
		}catch(Exception e){
			e.printStackTrace();
			try {
				throw new Exception("DOCUMENTS DELETE EXCEPTION");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
}
