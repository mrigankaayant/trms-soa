package com.ayantsoft.trms.resourcing.service;

import java.io.File;
import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;

import com.ayantsoft.trms.resourcing.dao.ResumeDao;

@Service
public class ResumeServiceImpl implements Serializable,ResumeService {

	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = -2505973175271416516L;
	
	@Autowired
	private ResumeDao resumeDao;

	@Override
	public void uploadResume(String fileName, File file, String contentType) {
		resumeDao.uploadResume(fileName, file, contentType); 
	}

	@Override
	public InputStreamResource downResume(String fileName) {
		return resumeDao.downResume(fileName);
	}
}
