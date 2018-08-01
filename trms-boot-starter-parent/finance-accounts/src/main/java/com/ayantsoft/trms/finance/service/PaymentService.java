package com.ayantsoft.trms.finance.service;

import com.ayantsoft.trms.finance.dto.LazyPaymentDto;
import com.ayantsoft.trms.finance.lazy.model.LazyLoadEvent;
import com.ayantsoft.trms.finance.model.PaymentDetails;

public interface PaymentService {
	
	LazyPaymentDto list(LazyLoadEvent lazyLoadEvent,String status);
	PaymentDetails findById(String paymentId);
	void update(PaymentDetails paymentDetails);

}
