package com.ayantsoft.trms.resourcing.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "max_followup")
public class MaxFollowUp implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1441774505659202710L;
	
	@Id
	private String id;
	
	private Date maxFollowUpDate;
	private String recruiterId;
	private String candidateId;
	private String candidateName;
	private String candidateEmail;
	private String candidateWorkMobile;
	private String candidateStatus;
	private String recruiterName;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getMaxFollowUpDate() {
		return maxFollowUpDate;
	}
	public void setMaxFollowUpDate(Date maxFollowUpDate) {
		this.maxFollowUpDate = maxFollowUpDate;
	}
	public String getRecruiterId() {
		return recruiterId;
	}
	public void setRecruiterId(String recruiterId) {
		this.recruiterId = recruiterId;
	}
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
	public String getCandidateEmail() {
		return candidateEmail;
	}
	public void setCandidateEmail(String candidateEmail) {
		this.candidateEmail = candidateEmail;
	}
	public String getCandidateWorkMobile() {
		return candidateWorkMobile;
	}
	public void setCandidateWorkMobile(String candidateWorkMobile) {
		this.candidateWorkMobile = candidateWorkMobile;
	}
	public String getCandidateStatus() {
		return candidateStatus;
	}
	public void setCandidateStatus(String candidateStatus) {
		this.candidateStatus = candidateStatus;
	}
	public String getRecruiterName() {
		return recruiterName;
	}
	public void setRecruiterName(String recruiterName) {
		this.recruiterName = recruiterName;
	}
}
