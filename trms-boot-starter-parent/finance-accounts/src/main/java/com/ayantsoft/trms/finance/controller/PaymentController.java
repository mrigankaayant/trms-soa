package com.ayantsoft.trms.finance.controller;

import java.io.Serializable;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ayantsoft.trms.finance.dto.LazyPaymentDto;
import com.ayantsoft.trms.finance.info.URLInfo;
import com.ayantsoft.trms.finance.lazy.model.LazyLoadEvent;
import com.ayantsoft.trms.finance.service.PaymentService;

@RestController
@RequestMapping(URLInfo.ROOTURL)
public class PaymentController implements Serializable{
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 2539796886133987648L;

	@Autowired
	private PaymentService paymentService;

	@PostMapping(URLInfo.LAZY_PAYMENT_LIST)
	@PreAuthorize("hasAuthority('TRMSRES_PAYMENTDETAILS_LIST')")
	public ResponseEntity<?> paymentDetailsList(@RequestBody LazyLoadEvent lazyLoadEvent,HttpServletRequest request){

		HttpStatus httpStatus = null;
		LazyPaymentDto lazyPaymentDto = null;
		try{
			lazyPaymentDto = paymentService.list(lazyLoadEvent,"UNVERIFIED");
			if(lazyPaymentDto == null){
				httpStatus = HttpStatus.NO_CONTENT;
			}else{
				httpStatus = HttpStatus.OK;
			}
		}catch(Exception e){
			e.printStackTrace();
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<LazyPaymentDto>(lazyPaymentDto,httpStatus);
	}



}
