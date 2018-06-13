package com.ayantsoft.trms.resourcing.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ayantsoft.trms.resourcing.model.Location;
import com.ayantsoft.trms.resourcing.service.PreferredLocationService;

@RestController
@RequestMapping("/resourcing/preferredLocation")
public class PreferredLocationController implements Serializable {

	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = 8022188503614310002L;

	@Autowired
	private PreferredLocationService preferredLocationService;

	@GetMapping("/list")
	public ResponseEntity<?> getLocations(){
		List<Location> list = null;
		HttpStatus httpStatus = null;
		try{
			list = preferredLocationService.list();

			if(list == null || list.isEmpty()){
				httpStatus = HttpStatus.NO_CONTENT;
			}else{
				httpStatus = HttpStatus.OK;
			}
		}catch(Exception e){
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<List<Location>>(list, httpStatus);
	}
}
