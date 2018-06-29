package com.ayantsoft.trms.resourcing.service;

import javax.servlet.http.HttpServletRequest;

import com.ayantsoft.trms.resourcing.model.Employee;

public interface EmployeeService {
	
	Employee getEmployeeByUsername(HttpServletRequest request,String username);

}
