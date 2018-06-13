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
	private String employeeId;
	private String supervisorId;
	private String payType;
	private String email;
	private Double payRate;
	private String altEmail;
	private Date graduationDate;
	private String workMobile;
	private List<String> skills;
	private String phone;
	private String enrollmentStatus;
	private List<Visa> visas;
	private String recruitmentSource;
	private Date nextFollowupDate;
	private Double courseFee;
	private String recruitmentService;
	private Date createdDate;
	private String currentLocation;
	private List<String> prefferedLocations;
	
	
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
	public List<String> getSkills() {
		return skills;
	}
	public void setSkills(List<String> skills) {
		this.skills = skills;
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
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getSupervisorId() {
		return supervisorId;
	}
	public void setSupervisorId(String supervisorId) {
		this.supervisorId = supervisorId;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}	
}