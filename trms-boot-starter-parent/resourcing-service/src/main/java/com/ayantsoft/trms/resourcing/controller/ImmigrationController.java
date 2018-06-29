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
import com.ayantsoft.trms.resourcing.model.Immigration;
import com.ayantsoft.trms.resourcing.service.ImmigrationService;

@RestController
@RequestMapping(URLInfo.ROOTURL)
public class ImmigrationController implements Serializable {

	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = -6783554180979335111L;

	@Autowired
	private ImmigrationService immigrationService;

	@GetMapping(URLInfo.VISA_LIST)
	@PreAuthorize("hasAuthority('TRMSRES_CANDIDATE_READ')")
	public ResponseEntity<?> getVises(){
		List<Immigration> list = null;
		HttpStatus httpStatus = null;
		try{
			list = immigrationService.list();
			
			if(list == null || list.isEmpty()){
				httpStatus = HttpStatus.NO_CONTENT;
			}else{
				httpStatus = HttpStatus.OK;
			}
		}catch(Exception e){
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<List<Immigration>>(list, httpStatus);
	}



}
