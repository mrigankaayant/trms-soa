package com.ayantsoft.trms.resourcing.model;

import java.io.Serializable;

public class ResumeInfo implements Serializable{

	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = -6325290575194862288L;
	
	private String documentId;
	private String documentName;
	private String fileName;
	
	public String getDocumentId() {
		return documentId;
	}
	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}
	public String getDocumentName() {
		return documentName;
	}
	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
