package com.ayantsoft.trms.resourcing.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="phone_logs")
public class PhoneLogs implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7728359831043736971L;
	
	@Id
	private String id;
	private String employeeName;
	private String extension;
	private String destNumber;
	private String candidateName;
	private String callDuration;
	private String callStatus;
	private Date callingDate;
	private String inOut;
	private String callingLocation;
	private String candidateEmail;
	private String candidateId;
	private String srcNumber;
	private String employeeId;
	private String supervisorName;
	private String supervisorId;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	public String getDestNumber() {
		return destNumber;
	}
	public void setDestNumber(String destNumber) {
		this.destNumber = destNumber;
	}
	public String getCandidateName() {
		return candidateName;
	}
	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}
	public String getCallDuration() {
		return callDuration;
	}
	public void setCallDuration(String callDuration) {
		this.callDuration = callDuration;
	}
	public String getCallStatus() {
		return callStatus;
	}
	public void setCallStatus(String callStatus) {
		this.callStatus = callStatus;
	}
	public Date getCallingDate() {
		return callingDate;
	}
	public void setCallingDate(Date callingDate) {
		this.callingDate = callingDate;
	}
	public String getInOut() {
		return inOut;
	}
	public void setInOut(String inOut) {
		this.inOut = inOut;
	}
	public String getCallingLocation() {
		return callingLocation;
	}
	public void setCallingLocation(String callingLocation) {
		this.callingLocation = callingLocation;
	}
	public String getCandidateEmail() {
		return candidateEmail;
	}
	public void setCandidateEmail(String candidateEmail) {
		this.candidateEmail = candidateEmail;
	}
	public String getCandidateId() {
		return candidateId;
	}
	public void setCandidateId(String candidateId) {
		this.candidateId = candidateId;
	}
	public String getSrcNumber() {
		return srcNumber;
	}
	public void setSrcNumber(String srcNumber) {
		this.srcNumber = srcNumber;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getSupervisorName() {
		return supervisorName;
	}
	public void setSupervisorName(String supervisorName) {
		this.supervisorName = supervisorName;
	}
	public String getSupervisorId() {
		return supervisorId;
	}
	public void setSupervisorId(String supervisorId) {
		this.supervisorId = supervisorId;
	}
}
