package com.ayantsoft.trms.resourcing.dao;

import java.io.File;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.stereotype.Repository;
import com.mongodb.DB;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;

@Repository
public class ResumeDaoImpl implements ResumeDao,Serializable {

	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = 6272672303924644550L;

	@Autowired
	private MongoDbFactory mongoDbFactory;


	@Override
	public void uploadResume(String fileName, File file, String contentType) {
		try{
			DB db = mongoDbFactory.getLegacyDb();
			GridFS gridFS = new GridFS(db,"upload_resume"); 
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
				throw new Exception("UPLOAD RESUME EXCEPTION");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}


	@Override
	public InputStreamResource downResume(String fileName) {
		InputStreamResource in = null;
		try{
			DB db = mongoDbFactory.getLegacyDb();
			GridFS gridFS = new GridFS(db,"upload_resume");
			GridFSDBFile gridFile = gridFS.findOne(fileName);
			in = new InputStreamResource(gridFile.getInputStream());
		}catch(Exception e){
			e.printStackTrace();
			try{
				throw new Exception("DOWNLOAD RESUME EXCEPTION");
			}catch(Exception e1){
				e1.printStackTrace();
			}
		}
		return in;
	}


	@Override
	public void deleteResule(String fileName) {
		try{
			DB db = mongoDbFactory.getLegacyDb();
			GridFS gridFS = new GridFS(db,"upload_resume"); 
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
		}catch(Exception e){
			try {
				throw new Exception("DELETE RESUME EXCEPTION");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}	
}
