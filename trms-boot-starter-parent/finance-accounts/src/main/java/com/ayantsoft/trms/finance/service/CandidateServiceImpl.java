package com.ayantsoft.trms.finance.service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.ayantsoft.trms.finance.dto.LazyCandidateDto;
import com.ayantsoft.trms.finance.lazy.model.LazyLoadEvent;
import com.ayantsoft.trms.finance.model.Candidate;


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


	@Override
	public List<Candidate> findCandidateByProperty(HttpServletRequest request,String propertyName,String propertyValue) {
		
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Authorization", String.format("%s %s", "bearer",request.getHeader("authorization").replace("Bearer", "").trim()));
		headers.add("Content-Type", "application/json");
		HttpEntity<String> req = new HttpEntity<String>(headers);
		Map<String,String> uriParams = new HashMap<String,String>();
		uriParams.put("propertyName", propertyName);
		uriParams.put("propertyValue", propertyValue);
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString("http://localhost:9999/resourcing/candidate/accountverify/{propertyName}/{propertyValue:.+}");
		
		ResponseEntity<?> result = restTemplate.exchange(builder.buildAndExpand(uriParams).toUri(), HttpMethod.GET,req,List.class);
		
		List<Candidate> list = (List<Candidate>) result.getBody();
		return list;
	}


	@Override
	public Candidate findCandidateById(HttpServletRequest request,String candidateId) {
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Authorization", String.format("%s %s", "bearer",request.getHeader("authorization").replace("Bearer", "").trim()));
		headers.add("Content-Type", "application/json");
		HttpEntity<String> req = new HttpEntity<String>(headers);
		ResponseEntity<Candidate> result = restTemplate.exchange("http://localhost:9999/resourcing/candidate/find/"+candidateId, HttpMethod.GET,req,Candidate.class);
		Candidate candidate = result.getBody();
		return candidate;
	}	
}
