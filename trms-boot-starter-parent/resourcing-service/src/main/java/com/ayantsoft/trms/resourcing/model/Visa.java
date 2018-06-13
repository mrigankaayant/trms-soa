package com.ayantsoft.trms.resourcing.model;

import java.io.Serializable;
import java.util.Date;

public class Visa implements Serializable {
    
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3648226890402743807L;
	
	private String visaName;
	private Date visaStartDate;
	
	public String getVisaName() {
		return visaName;
	}
	public void setVisaName(String visaName) {
		this.visaName = visaName;
	}
	public Date getVisaStartDate() {
		return visaStartDate;
	}
	public void setVisaStartDate(Date visaStartDate) {
		this.visaStartDate = visaStartDate;
	}
}
