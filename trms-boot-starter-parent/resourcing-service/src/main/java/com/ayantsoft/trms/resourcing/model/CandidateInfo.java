package com.ayantsoft.trms.resourcing.model;

import java.io.Serializable;

public class CandidateInfo implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5868066138830080802L;
	
	private String candidateId;
	private String candidateName;
	private String email;
	private String workMobile;
	private String recruitmentStatus;
	private String recruiterName;
	
	
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
	public String getWorkMobile() {
		return workMobile;
	}
	public void setWorkMobile(String workMobile) {
		this.workMobile = workMobile;
	}
	public String getRecruiterName() {
		return recruiterName;
	}
	public void setRecruiterName(String recruiterName) {
		this.recruiterName = recruiterName;
	}
	public String getRecruitmentStatus() {
		return recruitmentStatus;
	}
	public void setRecruitmentStatus(String recruitmentStatus) {
		this.recruitmentStatus = recruitmentStatus;
	}
}
