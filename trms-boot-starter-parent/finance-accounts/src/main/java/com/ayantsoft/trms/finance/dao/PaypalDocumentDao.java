package com.ayantsoft.trms.finance.dao;

import java.io.File;

public interface PaypalDocumentDao {

	void uploadPaypalDocument(String fileName, File file, String contentType);

}
