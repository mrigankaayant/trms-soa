package com.ayantsoft.trms.resourcing.controller;

import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ayantsoft.trms.resourcing.info.URLInfo;
import com.ayantsoft.trms.resourcing.model.CandidateStatus;
import com.ayantsoft.trms.resourcing.service.CandidateStatusService;

@RestController
@RequestMapping(URLInfo.ROOTURL)
public class CandidateStatusController implements Serializable {
	
	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = -8144971977631257240L;
	
	
	@Autowired
	private CandidateStatusService candidateStatusService;
	
	
	@GetMapping(URLInfo.CANDIDATE_STATUS_LIST)
	@PreAuthorize("hasAuthority('TRMSRES_CANDIDATE_READ')")
	public ResponseEntity<?> getCandidateStatus(){
		List<CandidateStatus> list = null;
		HttpStatus httpStatus = null;
		try{
			list = candidateStatusService.list();
			
			if(list == null || list.isEmpty()){
				httpStatus = HttpStatus.NO_CONTENT;
			}else{
				httpStatus = HttpStatus.OK;
			}
		}catch(Exception e){
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<List<CandidateStatus>>(list, httpStatus);
	}

}
