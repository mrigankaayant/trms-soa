package com.ayantsoft.trms.employee.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayantsoft.trms.employee.dao.EmployeeDao;
import com.ayantsoft.trms.employee.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService,Serializable {

	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = -8880059957482102342L;

	@Autowired
	private EmployeeDao employeeDao;


	@Override
	public Employee getEmployeeByUsername(String username) {
		return employeeDao.getEmployeeByUsername(username);
	}
}
