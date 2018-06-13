package com.ayantsoft.trms.resourcing.model;

import java.io.Serializable;

public class Location implements Serializable {

	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = 6438754832375566142L;


	private String name;
	private String code;


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



