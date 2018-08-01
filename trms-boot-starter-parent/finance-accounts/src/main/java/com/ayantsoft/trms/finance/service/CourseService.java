package com.ayantsoft.trms.finance.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ayantsoft.trms.finance.model.Course;

public interface CourseService {
	
	List<Course> list(HttpServletRequest request);

}
