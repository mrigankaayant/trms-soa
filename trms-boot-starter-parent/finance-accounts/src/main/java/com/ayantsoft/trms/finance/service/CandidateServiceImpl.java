package com.ayantsoft.trms.finance.service;

import java.io.Serializable;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import com.ayantsoft.trms.finance.dto.LazyCandidateDto;
import com.ayantsoft.trms.finance.lazy.model.LazyLoadEvent;


@Service
public class CandidateServiceImpl implements Serializable,CandidateService {

	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = -2340783495758464724L;

	@Autowired
	private RestTemplate restTemplate;


	@Override
	public LazyCandidateDto list(HttpServletRequest request,LazyLoadEvent lazyLoadEvent) {
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Authorization", String.format("%s %s", "bearer",request.getHeader("authorization").replace("Bearer", "").trim()));
		headers.add("Content-Type", "application/json");
		HttpEntity<LazyLoadEvent> req = new HttpEntity<LazyLoadEvent>(lazyLoadEvent,headers);
		ResponseEntity<LazyCandidateDto> result = restTemplate.exchange("http://localhost:9999/resourcing/all/candidate/lazy/list", HttpMethod.POST,req,LazyCandidateDto.class);
		LazyCandidateDto lazyCandidateDto = result.getBody();
		return lazyCandidateDto;
	}	
}
