package com.ayantsoft.trms.finance.service;

import javax.servlet.http.HttpServletRequest;
import com.ayantsoft.trms.finance.model.Employee;

public interface EmployeeService {
	
	Employee getEmployeeByUsername(HttpServletRequest request,String username);

}
