package com.ayantsoft.trms.resourcing.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import com.ayantsoft.trms.resourcing.info.DatabaseInfo;
import com.ayantsoft.trms.resourcing.model.Course;

@Repository
public class CourseDaoImpl implements CourseDao,Serializable {
	
	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = 3127172143119084027L;
	
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<Course> list() {
		List<Course> list = null;
		try{
			list = mongoTemplate.findAll(Course.class,DatabaseInfo.COURSE_COLLECTION);
		}catch(Exception e){
			e.printStackTrace();
			try{
				throw new Exception("COURSE LIST EXCEPTION");
			}catch(Exception e1){
				e1.printStackTrace();
			}
		}
		return list;
	}
}
