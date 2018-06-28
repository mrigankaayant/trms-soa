package com.ayantsoft.trms.employee.service;

import java.util.List;

import com.ayantsoft.trms.employee.model.Employee;

public interface EmployeeService {
	
	Employee create(Employee employee);
	Employee getEmployeeByUsername(String username);
	void update(Employee employee);
	void delete(String employeeId);
	List<Employee> list();
}
