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
import com.ayantsoft.trms.resourcing.model.IncentiveStructure;
import com.ayantsoft.trms.resourcing.service.IncentiveStructureService;

@RestController
@RequestMapping(URLInfo.ROOTURL)
public class IncentiveStructureController implements Serializable{

	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = 4654440804283640734L;
	
	@Autowired
	private IncentiveStructureService incentiveStructureService;
	
	
	@GetMapping(URLInfo.INCENTIVE_LIST)
	@PreAuthorize("hasAuthority('TRMSRES_INCENTIVE_LIST')")
	public ResponseEntity<?> getIncentiveList(@PathVariable("incentiveFor") String incentiveFor){
		
		List<IncentiveStructure> list = null;
		HttpStatus httpStatus = null;
		try{
			list = incentiveStructureService.findIncentiveList(incentiveFor);
			
			if(list == null || list.isEmpty()){
				httpStatus = HttpStatus.NO_CONTENT;
			}else{
				httpStatus = HttpStatus.OK;
			}
		}catch(Exception e){
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<List<IncentiveStructure>>(list, httpStatus);
	}
}
