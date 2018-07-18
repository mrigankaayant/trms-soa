package com.ayantsoft.trms.resourcing.service;

import java.io.File;

import org.springframework.core.io.InputStreamResource;

public interface ResumeService {
	
	void uploadResume(String fileName, File file, String contentType);
	InputStreamResource downResume(String fileName);
	void deleteResule(String fileName);

}
