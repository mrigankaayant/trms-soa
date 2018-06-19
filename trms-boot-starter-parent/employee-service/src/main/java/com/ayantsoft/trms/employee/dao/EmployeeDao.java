package com.ayantsoft.trms.employee.dao;

import com.ayantsoft.trms.employee.model.Employee;

public interface EmployeeDao {
	
	Employee getEmployeeByUsername(String username);

}
