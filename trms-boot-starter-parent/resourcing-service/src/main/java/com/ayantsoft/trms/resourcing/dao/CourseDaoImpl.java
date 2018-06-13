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
			list = mongoTemplate.findAll(Course.class,DatabaseInfo.COURSECOLLECTION);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
}