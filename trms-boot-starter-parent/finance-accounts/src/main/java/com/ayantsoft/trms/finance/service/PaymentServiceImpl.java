package com.ayantsoft.trms.finance.service;

import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ayantsoft.trms.finance.dao.PaymentDao;
import com.ayantsoft.trms.finance.dto.LazyPaymentDto;
import com.ayantsoft.trms.finance.lazy.model.LazyLoadEvent;

@Service
public class PaymentServiceImpl implements Serializable,PaymentService {

	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = -5103607403328103877L;


	@Autowired
	private PaymentDao paymentDao;


	@Override
	public LazyPaymentDto list(LazyLoadEvent lazyLoadEvent,String status) {
		return paymentDao.list(lazyLoadEvent,status);
	}

}
