package com.ayantsoft.trms.resourcing.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "candidate_status")
public class CandidateStatus implements Serializable {

	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = 8256810258795431279L;
	
	
	@Id
	private String id;
	private String status;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
