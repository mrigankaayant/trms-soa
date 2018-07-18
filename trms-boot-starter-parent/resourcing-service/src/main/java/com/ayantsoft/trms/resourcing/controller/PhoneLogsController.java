package com.ayantsoft.trms.resourcing.controller;

import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ayantsoft.trms.resourcing.info.URLInfo;
import com.ayantsoft.trms.resourcing.model.PhoneLogs;
import com.ayantsoft.trms.resourcing.service.PhoneLogsService;

@RestController
@RequestMapping(URLInfo.ROOTURL)
public class PhoneLogsController implements Serializable {

	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = 7832567348043451663L;

	@Autowired
	private PhoneLogsService phoneLogsService;


	@GetMapping(URLInfo.PHONE_LOGS_LIST_BY_EMPLOYEE_ID)
	@PreAuthorize("hasAuthority('TRMSRES_PHONELOG_LIST')")
	public ResponseEntity<?> phoneLogsListByEmployeeId(@PathVariable("employeeId") String employeeId){

		HttpStatus httpStatus = null;
		List<PhoneLogs> phoneLogsList = null;
		try{
			phoneLogsList = phoneLogsService.listByEmployeeId(employeeId);			

			if(phoneLogsList == null){
				httpStatus = HttpStatus.NO_CONTENT;
			}else{
				httpStatus = HttpStatus.OK;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ResponseEntity<List<PhoneLogs>>(phoneLogsList,httpStatus);
	}


	@GetMapping(URLInfo.PHONE_LOGS_LIST_BY_CANDIDATE_ID)
	@PreAuthorize("hasAuthority('TRMSRES_PHONELOG_LIST')")
	public ResponseEntity<?> phoneLogsListByCandidateId(@PathVariable("candidateId") String candidateId){

		HttpStatus httpStatus = null;
		List<PhoneLogs> phoneLogsList = null;
		try{
			phoneLogsList = phoneLogsService.listByCandidateId(candidateId);	

			if(phoneLogsList == null){
				httpStatus = HttpStatus.NO_CONTENT;
			}else{
				httpStatus = HttpStatus.OK;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ResponseEntity<List<PhoneLogs>>(phoneLogsList,httpStatus);
	}
}
