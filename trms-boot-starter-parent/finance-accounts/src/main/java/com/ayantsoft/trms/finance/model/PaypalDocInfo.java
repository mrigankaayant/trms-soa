package com.ayantsoft.trms.finance.model;

import java.io.Serializable;

public class PaypalDocInfo implements Serializable {
	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = -7142163241242306072L;
	
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
