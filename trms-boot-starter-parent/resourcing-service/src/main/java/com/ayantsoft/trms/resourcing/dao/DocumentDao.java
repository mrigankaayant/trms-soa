package com.ayantsoft.trms.resourcing.dao;

import com.ayantsoft.trms.resourcing.model.Documents;

public interface DocumentDao {
	
	void save(Documents documents);
	Documents find(String fileName);
	void delete(Documents documents);
}
