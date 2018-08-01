package com.ayantsoft.trms.finance.dao;

import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import com.ayantsoft.trms.finance.info.DatabaseInfo;
import com.ayantsoft.trms.finance.model.Documents;

@Repository
public class DocumentDaoImpl implements Serializable,DocumentDao {
	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = 7409562686770281484L;
	
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
				throw new Exception("PAYPAL DOCUMENT SAVE EXCEPTION");
			}catch(Exception e1){
				e1.printStackTrace();
			}
		}
	}
}
