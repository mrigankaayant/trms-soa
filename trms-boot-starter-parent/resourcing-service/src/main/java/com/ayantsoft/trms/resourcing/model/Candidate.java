package com.ayantsoft.trms.resourcing.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "candidate")
public class Candidate implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -8619889826974320835L;
	
	@Id
	private String id;
	private String candidateId;
	private String candidateName;
	private String payType;
	private String email;
	private Double payRate;
	private String altEmail;
	private Date graduationDate;
	private String workMobile;
	private String highestQualification;
	private String skill;
	private String phone;
	private String enrollmentStatus;
	private String visa;
	private Date visaStartDate;
	private String recruitmentSource;
	private Date nextFollowupDate;
	private Double courseFee;
	private String recruitmentService;
	private Date createdDate;
	private String currentLocation;
	private List<String> prefferedLocations;
	private CreatedBy createdBy;
	private UpdatedBy updatedBy;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Double getPayRate() {
		return payRate;
	}
	public void setPayRate(Double payRate) {
		this.payRate = payRate;
	}
	public String getAltEmail() {
		return altEmail;
	}
	public void setAltEmail(String altEmail) {
		this.altEmail = altEmail;
	}
	public Date getGraduationDate() {
		return graduationDate;
	}
	public void setGraduationDate(Date graduationDate) {
		this.graduationDate = graduationDate;
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
	public String getEnrollmentStatus() {
		return enrollmentStatus;
	}
	public void setEnrollmentStatus(String enrollmentStatus) {
		this.enrollmentStatus = enrollmentStatus;
	}
	public String getRecruitmentSource() {
		return recruitmentSource;
	}
	public void setRecruitmentSource(String recruitmentSource) {
		this.recruitmentSource = recruitmentSource;
	}
	public Double getCourseFee() {
		return courseFee;
	}
	public void setCourseFee(Double courseFee) {
		this.courseFee = courseFee;
	}
	public String getRecruitmentService() {
		return recruitmentService;
	}
	public void setRecruitmentService(String recruitmentService) {
		this.recruitmentService = recruitmentService;
	}
	public String getCurrentLocation() {
		return currentLocation;
	}
	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}
	public List<String> getPrefferedLocations() {
		return prefferedLocations;
	}
	public void setPrefferedLocations(List<String> prefferedLocations) {
		this.prefferedLocations = prefferedLocations;
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
	public Date getNextFollowupDate() {
		return nextFollowupDate;
	}
	public void setNextFollowupDate(Date nextFollowupDate) {
		this.nextFollowupDate = nextFollowupDate;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public CreatedBy getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(CreatedBy createdBy) {
		this.createdBy = createdBy;
	}
	public UpdatedBy getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(UpdatedBy updatedBy) {
		this.updatedBy = updatedBy;
	}
	public String getVisa() {
		return visa;
	}
	public void setVisa(String visa) {
		this.visa = visa;
	}
	public Date getVisaStartDate() {
		return visaStartDate;
	}
	public void setVisaStartDate(Date visaStartDate) {
		this.visaStartDate = visaStartDate;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public String getHighestQualification() {
		return highestQualification;
	}
	public void setHighestQualification(String highestQualification) {
		this.highestQualification = highestQualification;
	}
}
