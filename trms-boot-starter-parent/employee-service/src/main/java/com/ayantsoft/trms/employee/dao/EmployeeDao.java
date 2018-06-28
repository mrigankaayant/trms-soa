package com.ayantsoft.trms.employee.dao;

import java.util.List;

import com.ayantsoft.trms.employee.model.Employee;

public interface EmployeeDao {
	
	Employee create(Employee employee);
	Employee getEmployeeByUsername(String username);
	void update(Employee employee);
	void delete(String employeeId);
	List<Employee> list();
}
