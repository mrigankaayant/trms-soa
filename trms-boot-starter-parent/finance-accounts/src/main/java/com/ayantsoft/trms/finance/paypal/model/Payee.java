package com.ayantsoft.trms.finance.paypal.model;

public class Payee {
	
	private String email;
	private String merchantId;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}
}
