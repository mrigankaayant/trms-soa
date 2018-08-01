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
import com.ayantsoft.trms.finance.model.RecruitmentSource;
import com.ayantsoft.trms.finance.service.RecruitmentSourceService;

@RestController
@RequestMapping(URLInfo.ROOTURL)
public class RecruitmentSourceController implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4119457017887917008L;
	
	@Autowired
	private RecruitmentSourceService recruitmentSourceService;

	@GetMapping(URLInfo.RECRUITMENT_SOURCE_LIST)
	@PreAuthorize("hasAuthority('TRMSRES_CANDIDATE_READ')")
	public ResponseEntity<?> getRecruitmentSources(HttpServletRequest request){
		List<RecruitmentSource> list = null;
		HttpStatus httpStatus = null;
		try{
			list = recruitmentSourceService.list(request);
			
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

