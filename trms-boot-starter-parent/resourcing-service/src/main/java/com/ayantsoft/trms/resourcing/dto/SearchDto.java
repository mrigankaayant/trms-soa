package com.ayantsoft.trms.resourcing.dto;

import java.io.Serializable;

public class SearchDto implements Serializable {

	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = 9103279196107441907L;
	
	private String candidateId;
	private String candidateName;
	private String email;
	private String altEmail;
	private String workMobile;
	private String phone;
	
	
	public String getCandidateId() {
		return candidateId;
	}
	public void setCandidateId(String candidateId) {
		this.candidateId = candidateId;
	}
	public String getCandidateName() {
		return candidateName;
	}
	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAltEmail() {
		return altEmail;
	}
	public void setAltEmail(String altEmail) {
		this.altEmail = altEmail;
	}
	public String getWorkMobile() {
		return workMobile;
	}
	public void setWorkMobile(String workMobile) {
		this.workMobile = workMobile;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
