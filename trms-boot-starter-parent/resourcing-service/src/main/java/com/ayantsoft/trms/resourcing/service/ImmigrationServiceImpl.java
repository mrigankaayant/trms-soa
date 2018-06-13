package com.ayantsoft.trms.resourcing.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayantsoft.trms.resourcing.dao.ImmigrationDao;
import com.ayantsoft.trms.resourcing.model.Immigration;

@Service
public class ImmigrationServiceImpl implements ImmigrationService,Serializable {
	
	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = -7920482351748222188L;
	
	
	@Autowired
	private ImmigrationDao immigrationDao;

	@Override
	public List<Immigration> list() {
		return immigrationDao.list();
	}

}
