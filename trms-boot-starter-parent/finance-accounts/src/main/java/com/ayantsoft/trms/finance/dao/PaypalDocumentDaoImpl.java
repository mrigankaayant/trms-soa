package com.ayantsoft.trms.finance.dao;

import java.io.File;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.stereotype.Repository;
import com.mongodb.DB;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;

@Repository
public class PaypalDocumentDaoImpl implements Serializable,PaypalDocumentDao {
	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = -3297109790746025632L;
	
	@Autowired
	private MongoDbFactory mongoDbFactory;
	
	
	@Override
	public void uploadPaypalDocument(String fileName, File file, String contentType) {
		try{
			DB db = mongoDbFactory.getLegacyDb();
			GridFS gridFS = new GridFS(db,"upload_paypal_document"); 
			GridFSDBFile gridFSDBFile = gridFS.findOne(fileName);

			if(gridFSDBFile != null){
				if(gridFSDBFile.getChunkSize() > 0){
					List<GridFSDBFile> fileList = gridFS.find(fileName);
					for (GridFSDBFile f : fileList)
					{
						gridFS.remove(f.getFilename());
					}
				}
			}
			GridFSInputFile gfsFile = gridFS.createFile(file);
			gfsFile.setFilename(fileName);
			gfsFile.setContentType(contentType);
			gfsFile.save();
		}catch(Exception e){
			try {
				throw new Exception("UPLOAD PAYPAL DOCUMENT EXCEPTION");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}	
	}
	
	
	
	
	
	
	

}
