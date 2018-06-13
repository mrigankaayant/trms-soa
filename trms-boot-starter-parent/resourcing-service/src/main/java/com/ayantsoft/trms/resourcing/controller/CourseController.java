package com.ayantsoft.trms.resourcing.controller;

import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ayantsoft.trms.resourcing.info.URLInfo;
import com.ayantsoft.trms.resourcing.model.Course;
import com.ayantsoft.trms.resourcing.service.CourseService;

@RestController
@RequestMapping(URLInfo.ROOTURL)
public class CourseController implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4061129231253734483L;
	
	
	@Autowired
	private CourseService courseService;

	@GetMapping(URLInfo.COURSELIST)
	public ResponseEntity<?> getCourses(){
		List<Course> list = null;
		HttpStatus httpStatus = null;
		try{
			list = courseService.list();
			
			if(list == null || list.isEmpty()){
				httpStatus = HttpStatus.NO_CONTENT;
			}else{
				httpStatus = HttpStatus.OK;
			}
		}catch(Exception e){
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<List<Course>>(list, httpStatus);
	}



}

