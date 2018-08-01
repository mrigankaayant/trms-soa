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
import com.ayantsoft.trms.finance.model.Employee;

@Service
public class EmployeeServiceimpl implements Serializable,EmployeeService {
	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = 1824567044857636661L;
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Employee getEmployeeByUsername(HttpServletRequest request,String username) {
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Authorization", String.format("%s %s", "bearer",request.getHeader("authorization").replace("Bearer", "").trim()));
		headers.add("Content-Type", "application/json");
		HttpEntity<String> req = new HttpEntity<String>(headers);
		ResponseEntity<Employee> result = restTemplate.exchange("http://localhost:8888/employee/find/"+username, HttpMethod.GET,req,Employee.class);
		Employee employee = result.getBody();
		return employee;
	}
}
