package com.ayantsoft.trms.finance.dao;

import com.ayantsoft.trms.finance.dto.LazyPaymentDto;
import com.ayantsoft.trms.finance.lazy.model.LazyLoadEvent;

public interface PaymentDao {
	
	LazyPaymentDto list(LazyLoadEvent lazyLoadEvent,String status);

}
