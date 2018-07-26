package com.ayantsoft.trms.finance.paypal.model;

public class PaymentInfo {
	
	private String paymentId;
	private String intent;
	private Payer payer;
	private String cart;
	private Transaction transactions;
	
	
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public String getIntent() {
		return intent;
	}
	public void setIntent(String intent) {
		this.intent = intent;
	}
	public Payer getPayer() {
		return payer;
	}
	public void setPayer(Payer payer) {
		this.payer = payer;
	}
	public String getCart() {
		return cart;
	}
	public void setCart(String cart) {
		this.cart = cart;
	}
	public Transaction getTransactions() {
		return transactions;
	}
	public void setTransactions(Transaction transactions) {
		this.transactions = transactions;
	}
}
