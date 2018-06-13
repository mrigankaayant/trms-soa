package com.ayantsoft.trms.resourcing.service;

import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ayantsoft.trms.resourcing.dao.CourseDao;
import com.ayantsoft.trms.resourcing.model.Course;

@Service
public class CourseServiceImpl implements CourseService,Serializable {
	
	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = 2538002851076382528L;
	
	
	@Autowired
	private CourseDao courseDao;

	@Override
	public List<Course> list() {
		return courseDao.list();
	}

}
