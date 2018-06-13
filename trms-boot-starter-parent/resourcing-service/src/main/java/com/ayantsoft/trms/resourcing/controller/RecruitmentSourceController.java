package com.ayantsoft.trms.resourcing.controller;

import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ayantsoft.trms.resourcing.model.RecruitmentSource;
import com.ayantsoft.trms.resourcing.service.RecruitmentSourceService;

@RestController
@RequestMapping("/resourcing/recruitmentsource")
public class RecruitmentSourceController implements Serializable {

	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = 8571545705570607132L;
	

	@Autowired
	private RecruitmentSourceService recruitmentSourceService;

	@GetMapping("/list")
	public ResponseEntity<?> getRecruitmentSources(){
		List<RecruitmentSource> list = null;
		HttpStatus httpStatus = null;
		try{
			list = recruitmentSourceService.list();
			
			if(list == null || list.isEmpty()){
				httpStatus = HttpStatus.NO_CONTENT;
			}else{
				httpStatus = HttpStatus.OK;
			}
		}catch(Exception e){
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<List<RecruitmentSource>>(list, httpStatus);
	}
}
