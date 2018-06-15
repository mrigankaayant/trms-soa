package com.ayantsoft.trms.resourcing.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayantsoft.trms.resourcing.dao.PayTypeDao;
import com.ayantsoft.trms.resourcing.model.PayType;

@Service
public class PayTypeServiceImpl implements PayTypeService,Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3408114632669495752L;

	@Autowired
	private PayTypeDao payTypeDao;

	@Override
	public List<PayType> list() {
		return payTypeDao.list();
	}
}
