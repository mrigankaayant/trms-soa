package com.ayantsoft.trms.finance.service;

import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ayantsoft.trms.finance.dao.DocumentDao;
import com.ayantsoft.trms.finance.model.Documents;

@Service
public class DocumentServiceImpl implements Serializable,DocumentService {
	/**
	 *serialVersionUID
	 */
	private static final long serialVersionUID = -6900090897717705630L;

	@Autowired
	private DocumentDao documentDao;

	@Override
	public void save(Documents documents) {
		documentDao.save(documents); 
	}
}
