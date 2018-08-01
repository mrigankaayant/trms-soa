package com.ayantsoft.trms.finance.model;

import java.io.Serializable;
import org.springframework.data.annotation.Id;

public class RecruitmentSource implements Serializable {
	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = 7146904314407691474L;
	
	@Id
	private String id;
	private String name;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
