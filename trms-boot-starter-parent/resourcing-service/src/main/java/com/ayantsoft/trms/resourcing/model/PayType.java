package com.ayantsoft.trms.resourcing.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pay_type")
public class PayType implements Serializable {

	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = 6641493350852097166L;
	
	@Id
	private String id;
	private String type;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
