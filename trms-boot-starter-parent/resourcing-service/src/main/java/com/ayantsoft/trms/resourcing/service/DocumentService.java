package com.ayantsoft.trms.resourcing.service;

import com.ayantsoft.trms.resourcing.model.Documents;

public interface DocumentService {

	void save(Documents documents);
	Documents find(String fileName);
	void delete(Documents documents);
}
