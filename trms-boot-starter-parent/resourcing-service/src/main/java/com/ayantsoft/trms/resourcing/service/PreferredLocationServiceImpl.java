package com.ayantsoft.trms.resourcing.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayantsoft.trms.resourcing.dao.PreferredLocationDao;
import com.ayantsoft.trms.resourcing.model.Location;

@Service
public class PreferredLocationServiceImpl implements PreferredLocationService,Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6483728220174822104L;
	
	@Autowired
	private PreferredLocationDao preferredLocationDao;

	@Override
	public List<Location> list() {
		return preferredLocationDao.list();
	}
}
