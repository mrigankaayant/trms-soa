package com.ayantsoft.trms.resourcing.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.ayantsoft.trms.resourcing.model.Visa;

public class CandidateDto implements Serializable {
	
	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = 3148171291945933939L;
	
	
	private String candidateId;
	private String candidateName;
	private String payType;
	private String email;
	private Double payRate;
	private String altEmail;
	private Date graduationDate;
	private String workMobile;
	private String currentLocation;
	private String phone;
	private List<Visa> visas;
	private String recruitmentSource;
	private List<String> skills;
	private Double courseFee;
	private String enrollmentStatus;
	private Date nextFollowUpDate;
	private String recruitmentService;
	private List<String> prefferedLocations;
	
	
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
	public String getCurrentLocation() {
		return currentLocation;
	}
	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public List<Visa> getVisas() {
		return visas;
	}
	public void setVisas(List<Visa> visas) {
		this.visas = visas;
	}
	public String getRecruitmentSource() {
		return recruitmentSource;
	}
	public void setRecruitmentSource(String recruitmentSource) {
		this.recruitmentSource = recruitmentSource;
	}
	public List<String> getSkills() {
		return skills;
	}
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
	public Double getCourseFee() {
		return courseFee;
	}
	public void setCourseFee(Double courseFee) {
		this.courseFee = courseFee;
	}
	public String getEnrollmentStatus() {
		return enrollmentStatus;
	}
	public void setEnrollmentStatus(String enrollmentStatus) {
		this.enrollmentStatus = enrollmentStatus;
	}
	public Date getNextFollowUpDate() {
		return nextFollowUpDate;
	}
	public void setNextFollowUpDate(Date nextFollowUpDate) {
		this.nextFollowUpDate = nextFollowUpDate;
	}
	public String getRecruitmentService() {
		return recruitmentService;
	}
	public void setRecruitmentService(String recruitmentService) {
		this.recruitmentService = recruitmentService;
	}
	public List<String> getPrefferedLocations() {
		return prefferedLocations;
	}
	public void setPrefferedLocations(List<String> prefferedLocations) {
		this.prefferedLocations = prefferedLocations;
	}
}
