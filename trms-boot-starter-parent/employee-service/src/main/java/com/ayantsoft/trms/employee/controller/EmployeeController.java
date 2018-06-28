package com.ayantsoft.trms.employee.controller;

import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ayantsoft.trms.employee.info.URLInfo;
import com.ayantsoft.trms.employee.model.Employee;
import com.ayantsoft.trms.employee.service.EmployeeService;

@RestController
@RequestMapping(URLInfo.ROOTURL)
public class EmployeeController implements Serializable {

	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = 5192406234187304945L;

	@Autowired
	private EmployeeService employeeService;
	

	@PostMapping(URLInfo.CREATEEMPLOYEE)
	@PreAuthorize("hasAuthority('TRMSRES_CANDIDATE_CREATE')")
	public ResponseEntity<?> createEmployee(@RequestBody Employee employee){
		HttpStatus httpStatus = null;
		try{
			employeeService.create(employee);
			httpStatus = HttpStatus.OK;
		}catch(Exception e){
			e.printStackTrace();
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Employee>(employee,httpStatus);
	}
	

	@GetMapping(URLInfo.FINDEMPLOYEEBYUSERNAME)
	@PreAuthorize("hasAuthority('TRMSRES_CANDIDATE_READ')")
	public ResponseEntity<?> getEmployee(@PathVariable("username") String username){
		Employee employee = null;
		HttpStatus httpStatus = null;
		try{
			employee = employeeService.getEmployeeByUsername(username);

			if(employee == null){
				httpStatus = HttpStatus.NO_CONTENT;
			}else{
				httpStatus = HttpStatus.OK;
			}
		}catch(Exception e){
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Employee>(employee,httpStatus);
	}


	@PostMapping(URLInfo.UPDATEEMPLOYEE)
	@PreAuthorize("hasAuthority('TRMSRES_CANDIDATE_CREATE')")
	public ResponseEntity<?> updateEmployee(@RequestBody Employee employee){
		HttpStatus httpStatus = null;
		try{
			employeeService.update(employee);
			httpStatus = HttpStatus.OK;
		}catch(Exception e){
			e.printStackTrace();
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Employee>(employee,httpStatus);
	}


	@GetMapping(URLInfo.DELETEEMPLOYEE)
	@PreAuthorize("hasAuthority('TRMSRES_CANDIDATE_READ')")
	public ResponseEntity<?> deleteEmployee(@PathVariable("id") String employeeId){
		HttpStatus httpStatus = null;
		try{
			employeeService.delete(employeeId);
			httpStatus = HttpStatus.OK;
		}catch(Exception e){
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<String>(employeeId,httpStatus);
	}


	@GetMapping(URLInfo.LISTEMPLOYEE)
	@PreAuthorize("hasAuthority('TRMSRES_CANDIDATE_READ')")
	public ResponseEntity<?> listEmployee(){
		List<Employee> list = null;
		HttpStatus httpStatus = null;
		try{
			list = employeeService.list();
			if(list == null || list.isEmpty()){
				httpStatus = HttpStatus.NO_CONTENT;
			}else{
				httpStatus = HttpStatus.OK;
			}
		}catch(Exception e){
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<List<Employee>>(list,httpStatus);
	}
}
