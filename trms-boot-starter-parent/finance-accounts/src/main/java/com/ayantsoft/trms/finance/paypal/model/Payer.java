package com.ayantsoft.trms.finance.paypal.model;

public class Payer {
	
	private String paymentMethod;
	private String status;
	private PayerInfo payerInfo;
	
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public PayerInfo getPayerInfo() {
		return payerInfo;
	}
	public void setPayerInfo(PayerInfo payerInfo) {
		this.payerInfo = payerInfo;
	}
}
