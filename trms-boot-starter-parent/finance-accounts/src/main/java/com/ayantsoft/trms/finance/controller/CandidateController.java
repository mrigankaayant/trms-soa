package com.ayantsoft.trms.finance.controller;

import java.io.Serializable;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ayantsoft.trms.finance.dto.LazyCandidateDto;
import com.ayantsoft.trms.finance.info.URLInfo;
import com.ayantsoft.trms.finance.lazy.model.LazyLoadEvent;
import com.ayantsoft.trms.finance.model.Candidate;
import com.ayantsoft.trms.finance.service.CandidateService;

@RestController
@RequestMapping(URLInfo.ROOTURL)
public class CandidateController implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5507351049768179944L;
	
	@Autowired
	private CandidateService candidateService;
	
	
	@PostMapping(URLInfo.LAZY_CANDIDATE_LIST)
	@PreAuthorize("hasAuthority('TRMSRES_CANDIDATE_LIST')")
	public ResponseEntity<?> candidateList(@RequestBody LazyLoadEvent lazyLoadEvent,HttpServletRequest request){

		HttpStatus httpStatus = null;
		LazyCandidateDto lazyCandidateDto = null;
		try{
			lazyCandidateDto = candidateService.list(request,lazyLoadEvent);
			if(lazyCandidateDto == null){
				httpStatus = HttpStatus.NO_CONTENT;
			}else{
				httpStatus = HttpStatus.OK;
			}
		}catch(Exception e){
			e.printStackTrace();
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<LazyCandidateDto>(lazyCandidateDto,httpStatus);
	}
	

	@GetMapping(URLInfo.CANDIDATE_FIND_BY_PROPERTY)
	@PreAuthorize("hasAuthority('TRMSRES_CANDIDATE_READ')")
	public ResponseEntity<?> findCandidateByProperty(HttpServletRequest request,@PathVariable("propertyName") String propertyName,@PathVariable("propertyValue") String propertyValue){

		HttpStatus httpStatus = null;
		List<Candidate> list = null;
		try{
			list = candidateService.findCandidateByProperty(request,propertyName,propertyValue);
			
			if(list == null || list.isEmpty()){
				httpStatus = HttpStatus.NO_CONTENT;
			}else{
				httpStatus = HttpStatus.OK;
			}
		}catch(Exception e){
			e.printStackTrace();
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<List<Candidate>>(list,httpStatus);
	}
	
	
	@GetMapping(URLInfo.CANDIDATE_FIND_BY_ID)
	@PreAuthorize("hasAuthority('TRMSRES_CANDIDATE_READ')")
	public ResponseEntity<?> findCandidateById(HttpServletRequest request,@PathVariable("id") String candidateId){

		HttpStatus httpStatus = null;
		Candidate candidate = null;
		try{
			candidate = candidateService.findCandidateById(request,candidateId);
			if(candidate != null){
				httpStatus = HttpStatus.OK;
			}else{
				httpStatus = HttpStatus.NO_CONTENT;
			}
		}catch(Exception e){
			e.printStackTrace();
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Candidate>(candidate,httpStatus);
	}
}
