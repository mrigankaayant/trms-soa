package com.ayantsoft.trms.finance.service;

import java.io.Serializable;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import com.ayantsoft.trms.finance.model.Immigration;

@Service
public class ImmigrationServiceImpl implements ImmigrationService,Serializable {
	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = -1060234627593824419L;
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public List<Immigration> list(HttpServletRequest request) {
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Authorization", String.format("%s %s", "bearer",request.getHeader("authorization").replace("Bearer", "").trim()));
		headers.add("Content-Type", "application/json");
		HttpEntity<String> req = new HttpEntity<String>(headers);
		ResponseEntity<?> result = restTemplate.exchange("http://localhost:9999/resourcing/immigration/list", HttpMethod.GET,req,List.class);
		List<Immigration> list = (List<Immigration>) result.getBody();
		return list;
	}
}
