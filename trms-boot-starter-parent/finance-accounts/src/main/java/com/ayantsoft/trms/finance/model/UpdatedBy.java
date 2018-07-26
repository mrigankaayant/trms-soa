package com.ayantsoft.trms.finance.model;

import java.io.Serializable;

public class UpdatedBy implements Serializable {

	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = 2618888174531375915L;
	
	private String employeeId;
	private String employeeName;
	private String employeeEmail;
	private String employeePhone;
	private String updateDetails;
	
	
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeEmail() {
		return employeeEmail;
	}
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	public String getEmployeePhone() {
		return employeePhone;
	}
	public void setEmployeePhone(String employeePhone) {
		this.employeePhone = employeePhone;
	}
	public String getUpdateDetails() {
		return updateDetails;
	}
	public void setUpdateDetails(String updateDetails) {
		this.updateDetails = updateDetails;
	}
}
