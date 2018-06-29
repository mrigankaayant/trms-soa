package com.ayantsoft.trms.resourcing.model;

import java.io.Serializable;

public class Supervisor implements Serializable {

	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = -2467052903326814611L;
	
	private String supervisorId;
	private String supervisorName;
	private String supervisorEmail;
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
