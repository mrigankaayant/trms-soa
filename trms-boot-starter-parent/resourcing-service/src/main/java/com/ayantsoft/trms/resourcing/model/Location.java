package com.ayantsoft.trms.resourcing.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "locations")
public class Location implements Serializable {

	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = 6438754832375566142L;


	@Id
	private String id;
	private String name;
	private String code;

	
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
}



