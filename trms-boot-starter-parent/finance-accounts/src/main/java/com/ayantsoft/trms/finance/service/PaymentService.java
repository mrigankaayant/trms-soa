package com.ayantsoft.trms.finance.service;

import com.ayantsoft.trms.finance.dto.LazyPaymentDto;
import com.ayantsoft.trms.finance.lazy.model.LazyLoadEvent;

public interface PaymentService {
	
	LazyPaymentDto list(LazyLoadEvent lazyLoadEvent,String status);

}
