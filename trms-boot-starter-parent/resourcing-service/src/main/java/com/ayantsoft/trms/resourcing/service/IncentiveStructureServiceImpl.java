package com.ayantsoft.trms.resourcing.service;

import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ayantsoft.trms.resourcing.dao.IncentiveStructureDao;
import com.ayantsoft.trms.resourcing.model.IncentiveStructure;

@Service
public class IncentiveStructureServiceImpl implements Serializable,IncentiveStructureService {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1754561768693729745L;
	
	@Autowired
	private IncentiveStructureDao incentiveStructureDao;

	
	@Override
	public List<IncentiveStructure> findIncentiveList(String typeFor) {
		return incentiveStructureDao.findIncentiveList(typeFor);
	}
}
