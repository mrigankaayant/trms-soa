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
import com.ayantsoft.trms.resourcing.model.PayType;
import com.ayantsoft.trms.resourcing.service.PayTypeService;

@RestController
@RequestMapping(URLInfo.ROOTURL)
public class PayTypeController implements Serializable {

	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = -309391404159288934L;
	
	@Autowired
	private PayTypeService payTypeService;
	
	
	@GetMapping(URLInfo.PAYTYPELIST)
	@PreAuthorize("hasAuthority('TRMSRES_CANDIDATE_READ')")
	public ResponseEntity<?> getPayTypes(){
		List<PayType> list = null;
		HttpStatus httpStatus = null;
		try{
			list = payTypeService.list();
			
			if(list == null || list.isEmpty()){
				httpStatus = HttpStatus.NO_CONTENT;
			}else{
				httpStatus = HttpStatus.OK;
			}
		}catch(Exception e){
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<List<PayType>>(list, httpStatus);
	}
}
