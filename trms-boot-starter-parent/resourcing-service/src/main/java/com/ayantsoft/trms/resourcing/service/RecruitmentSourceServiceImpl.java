package com.ayantsoft.trms.resourcing.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayantsoft.trms.resourcing.dao.RecruitmentSourceDao;
import com.ayantsoft.trms.resourcing.model.RecruitmentSource;

@Service
public class RecruitmentSourceServiceImpl implements RecruitmentSourceService,Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3343121281537251600L;
	
	@Autowired
	private RecruitmentSourceDao recruitmentSourceDao;

	@Override
	public List<RecruitmentSource> list() {
		return recruitmentSourceDao.list();
	}
}
