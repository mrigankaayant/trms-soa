package com.ayantsoft.trms.finance.service;

import java.io.File;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ayantsoft.trms.finance.dao.PaypalDocumentDao;

@Service
public class PaypalDocumentServiceImpl implements Serializable,PaypalDocumentService {
	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = -7911397928074956756L;
	
	@Autowired
	private PaypalDocumentDao paypalDocumentDao;

	@Override
	public void uploadPaypalDocument(String fileName, File file, String contentType) {
		paypalDocumentDao.uploadPaypalDocument(fileName, file, contentType);
	}
}
