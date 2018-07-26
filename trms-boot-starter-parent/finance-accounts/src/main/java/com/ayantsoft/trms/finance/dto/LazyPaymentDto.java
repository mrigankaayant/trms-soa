package com.ayantsoft.trms.finance.dto;

import java.io.Serializable;
import java.util.List;

import com.ayantsoft.trms.finance.model.PaymentDetails;

public class LazyPaymentDto implements Serializable {
	
	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = 494734792560362311L;
	
	private List<PaymentDetails> paymentDetailsList;
	private long pageSize;
	private int pageNumber;
	
	
	public LazyPaymentDto(){
		
	}
	
	public LazyPaymentDto(List<PaymentDetails> paymentDetailsList,long pageSize,int pageNumber){
		this.paymentDetailsList = paymentDetailsList;
		this.pageSize = pageSize;
		this.pageNumber = pageNumber;
	}

	public List<PaymentDetails> getPaymentDetailsList() {
		return paymentDetailsList;
	}

	public void setPaymentDetailsList(List<PaymentDetails> paymentDetailsList) {
		this.paymentDetailsList = paymentDetailsList;
	}

	public long getPageSize() {
		return pageSize;
	}

	public void setPageSize(long pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
}
