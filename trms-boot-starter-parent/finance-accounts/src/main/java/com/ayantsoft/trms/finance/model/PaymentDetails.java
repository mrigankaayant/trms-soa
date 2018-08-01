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
	private String status;
	private Date createdDate;
	private String createdYear;
	private String createdMonth;
	private VerifiedBy verifiedBy;
	private PaymentInfo paymentInfo;
	private CandidateInfo candidateInfo;
	private PaypalDocInfo paypalDocInfo;
	
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
	public CandidateInfo getCandidateInfo() {
		return candidateInfo;
	}
	public void setCandidateInfo(CandidateInfo candidateInfo) {
		this.candidateInfo = candidateInfo;
	}
	public PaypalDocInfo getPaypalDocInfo() {
		return paypalDocInfo;
	}
	public void setPaypalDocInfo(PaypalDocInfo paypalDocInfo) {
		this.paypalDocInfo = paypalDocInfo;
	}
}
