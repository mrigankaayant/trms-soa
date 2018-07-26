package com.ayantsoft.trms.finance.model;

import java.io.Serializable;
import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.ayantsoft.trms.finance.paypal.model.PaymentInfo;

@Document(collection = "payment_details")
public class PaymentDetails implements Serializable {

	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = -6283694948872998728L;
	
	@Id
	private String id;
	private String paymentDetailsId;
	private String courseName;
	private String amount;
	private String candidateName;
	private String email;
	private String workMobile;
	private String pricePerItem;
	private String dueAmount;
	private String quantity;
	private String candidateId;
	private String status;
	private Date createdDate;
	private String createdYear;
	private String createdMonth;
	private VerifiedBy verifiedBy;
	private PaymentInfo paymentInfo;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPaymentDetailsId() {
		return paymentDetailsId;
	}
	public void setPaymentDetailsId(String paymentDetailsId) {
		this.paymentDetailsId = paymentDetailsId;
	}
	
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
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
	public String getPricePerItem() {
		return pricePerItem;
	}
	public void setPricePerItem(String pricePerItem) {
		this.pricePerItem = pricePerItem;
	}
	public String getDueAmount() {
		return dueAmount;
	}
	public void setDueAmount(String dueAmount) {
		this.dueAmount = dueAmount;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getCandidateId() {
		return candidateId;
	}
	public void setCandidateId(String candidateId) {
		this.candidateId = candidateId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getCreatedYear() {
		return createdYear;
	}
	public void setCreatedYear(String createdYear) {
		this.createdYear = createdYear;
	}
	public String getCreatedMonth() {
		return createdMonth;
	}
	public void setCreatedMonth(String createdMonth) {
		this.createdMonth = createdMonth;
	}
	public VerifiedBy getVerifiedBy() {
		return verifiedBy;
	}
	public void setVerifiedBy(VerifiedBy verifiedBy) {
		this.verifiedBy = verifiedBy;
	}
	public PaymentInfo getPaymentInfo() {
		return paymentInfo;
	}
	public void setPaymentInfo(PaymentInfo paymentInfo) {
		this.paymentInfo = paymentInfo;
	}
}
