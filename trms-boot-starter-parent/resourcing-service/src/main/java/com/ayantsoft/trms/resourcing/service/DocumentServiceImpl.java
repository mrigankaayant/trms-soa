package com.ayantsoft.trms.resourcing.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayantsoft.trms.resourcing.dao.DocumentDao;
import com.ayantsoft.trms.resourcing.model.Documents;

@Service
public class DocumentServiceImpl implements DocumentService,Serializable {

	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = 8113317091183449609L;

	@Autowired
	private DocumentDao documentDao;

	@Override
	public void save(Documents documents) {
		documentDao.save(documents);
	}

	@Override
	public Documents find(String fileName) {
		return documentDao.find(fileName);
	}

	@Override
	public void delete(Documents documents) {
		documentDao.delete(documents);
	}
}
