package com.ayantsoft.trms.finance.controller;

import java.io.Serializable;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ayantsoft.trms.finance.info.URLInfo;
import com.ayantsoft.trms.finance.model.Course;
import com.ayantsoft.trms.finance.service.CourseService;

@RestController
@RequestMapping(URLInfo.ROOTURL)
public class CourseController implements Serializable {

	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = 8158795780769582929L;
	
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping(URLInfo.COURSE_LIST)
	@PreAuthorize("hasAuthority('TRMSRES_CANDIDATE_READ')")
	public ResponseEntity<?> getCourses(HttpServletRequest request){
		List<Course> list = null;
		HttpStatus httpStatus = null;
		try{
			list = courseService.list(request);
			
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
