package com.ayantsoft.trms.finance.service;

import java.io.File;

public interface PaypalDocumentService {

	void uploadPaypalDocument(String fileName, File file, String contentType);
	
}
