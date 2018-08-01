package com.ayantsoft.trms.finance.model;

import java.io.Serializable;
import org.springframework.data.annotation.Id;

public class CandidateStatus implements Serializable {
	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = 2970502397592227929L;
	
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
