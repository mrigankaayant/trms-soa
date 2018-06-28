package com.ayantsoft.trms.employee.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Supervisor implements Serializable {

	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = 7752675493591480073L;

	@NotNull
	private String supervisorId;
	@NotNull
	private String supervisorName;
	@NotNull
	private String supervisorEmail;
	@NotNull
	@Size(min=13, message="Invalid Phone Number")
	private String supervisorPhone;
	
	
	public String getSupervisorId() {
		return supervisorId;
	}
	public void setSupervisorId(String supervisorId) {
		this.supervisorId = supervisorId;
	}
	public String getSupervisorName() {
		return supervisorName;
	}
	public void setSupervisorName(String supervisorName) {
		this.supervisorName = supervisorName;
	}
	public String getSupervisorEmail() {
		return supervisorEmail;
	}
	public void setSupervisorEmail(String supervisorEmail) {
		this.supervisorEmail = supervisorEmail;
	}
	public String getSupervisorPhone() {
		return supervisorPhone;
	}
	public void setSupervisorPhone(String supervisorPhone) {
		this.supervisorPhone = supervisorPhone;
	}
}
